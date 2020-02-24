package com.example.recyclerview;

import java.util.ArrayList;

public class FootBallData {
    private static String[] title = new String[] {"Jam Tangan 1", "Jam Tangan 2", "Jam Tangan 3", "Jam Tangan 4"};
    private static int[] thumbnail = new int[] {R.drawable.jam_tangan_1, R.drawable.jam_tangan_2, R.drawable.jam_tangan_3, R.drawable.jam_tangan_4};

    public static ArrayList<FootBallModel> getListData(){
        FootBallModel footBallModel = null;
        ArrayList<FootBallModel> list = new ArrayList<>();
        for (int i = 0; i < title.length; i++){
            footBallModel = new FootBallModel();
            footBallModel.setLogo(thumbnail[i]);
            footBallModel.setTeam_name(title[i]);
            list.add(footBallModel);
        }
        return list;
    }
}
