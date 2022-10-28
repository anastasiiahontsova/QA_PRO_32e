package com.telran.hontsova.homework.phonebook.fw;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Recorder extends ScreenRecorder {
    private final String pathName;


    public Recorder(GraphicsConfiguration cfg, String pathName) throws IOException, AWTException {
        super(cfg);
        this.pathName = pathName;
    }

    @Override
    public List<File> getCreatedMovieFiles() {
        return super.getCreatedMovieFiles();
    }

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
       /* SimpleDateFormat dateFormat = new SimpleDateFormat("_MM_dd_HH_mm");
        Date date = new Date();
        String dateInStringFormat = dateFormat.format(date);
        File newFile = new File(pathName + dateInStringFormat + "." + Registry.getInstance().getExtension(fileFormat));
        return newFile;*/

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_HH_mm");
        return new File(pathName + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
    }
}
