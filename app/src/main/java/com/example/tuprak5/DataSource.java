package com.example.tuprak5;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Data> dataList = generateDummyDataList();

    private static ArrayList<Data> generateDummyDataList() {
        ArrayList<Data> data = new ArrayList<>();
        data.add(new Data("asdjasd", "asnxscas",
                "1234567890",
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));

        data.add(new Data("adjasdha", "asjdhuasd",
                "12345uio",
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));

        data.add(new Data("asjdhhashud", "adjahsjdas",
                "qwesrdtfg",
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));

        data.add(new Data("asjajsdias", "asjkdajshda",
                "rtfcyvghjk",
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));

        data.add(new Data("asdkjkasd", "ajdnasjnd",
                "oiugfgh",
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));

        data.add(new Data("asdjhasjd", "asdjkasd",
                "sdftgvybhuj",
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));

        data.add(new Data("asjdjsadhj", "asdjhajsd",
                "sdfgvhbjnkm",
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));

        data.add(new Data("asjidsajhdsa", "asudhjsa",
                "erdtfgyhujnk",
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));

        data.add(new Data("nakhdjs", "asjdhjsa",
                "tfgyhbjnk",
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));

        data.add(new Data("sadqwd", "asdwqd",
                "tyghjknuhj",
                R.drawable.ic_launcher_background, R.drawable.ic_launcher_background));

        return data;
    }
}
