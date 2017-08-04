package com.example.shai.sadna;

/**
 * Created by Shai on 6/23/2017.
 */

import java.io.File;
import android.content.Context;

public class FileCache {

    private File cacheDir;
    Context context;


    public FileCache(Context context) { this.context =context;
        // Find the dir to save cached images
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED))
            cacheDir = new File(context.getFilesDir(), "file");
        else
            cacheDir = context.getCacheDir();
        if (!cacheDir.exists())
            cacheDir.mkdirs();
    }

    public File getFile(String url) {
        String filename = String.valueOf(url.hashCode());

        File f = new File(cacheDir, filename);
        return f;

    }

    public void clear() {
        File[] files = cacheDir.listFiles();
        if (files == null)
            return;
        for (File f : files)
            f.delete();
    }

}

