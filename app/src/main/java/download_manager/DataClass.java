package download_manager;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataClass {

    private Context context;

    public DataClass(Context context) {
        this.context = context;
    }

    public void downloadData(String fileUrl, Uri saveUri) {
        new Thread(() -> {
            HttpURLConnection connection = null;

            try {


                URL url = new URL(fileUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    Log.e("Download", "Server returned HTTP " + connection.getResponseCode());
                    return;
                }

                InputStream inputStream = connection.getInputStream();


                OutputStream outputStream = context.getContentResolver().openOutputStream(saveUri);

                if (outputStream == null) {
                    Log.e("Download", "Failed to open output stream.");
                    return;
                }

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();
                connection.disconnect();


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }).start();



    }
}
