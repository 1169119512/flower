package com.flower.test;

import com.flower.utils.WebUtils;
import org.junit.Test;

import java.io.File;
import java.util.Objects;

import static org.junit.Assert.*;

public class WebUtilsTest {
    WebUtils webUtils = new WebUtils();
    @Test
    public void createFile() {

    }

    @Test
    public void reNameFile() {
        webUtils.reNameFile("D:\\32455\\","ddddsa.jpg","1113");
    }

    @Test
    public void deleteFile() {
        File file = new File("D:\\32455");
        webUtils.deleteFile(file);
    }
}