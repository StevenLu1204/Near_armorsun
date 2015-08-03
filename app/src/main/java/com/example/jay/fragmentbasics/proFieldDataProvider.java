package com.example.jay.fragmentbasics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by armorsun on 2015/8/2.
 * this is a data provider
 * its stored the professional field data
 */
public class proFieldDataProvider {

    public static HashMap<String,List<String>> getInfo(){

        HashMap<String,List<String>> proFieldDetail=new HashMap<String,List<String>>();

        List<String> ComputerSciences=new ArrayList<String>();
        ComputerSciences.add("C++/C Programming");
        ComputerSciences.add("Swift Programming");
        ComputerSciences.add("Java Programming");
        ComputerSciences.add("Perl Programming");
        ComputerSciences.add("Web Design");
        ComputerSciences.add("Big Data");
        ComputerSciences.add("Arduino");
        ComputerSciences.add("System Analysis");

        List<String> Design=new ArrayList<String>();
        Design.add("Graphic Design");
        Design.add("3D Modeling");
        Design.add("Product Design");

        List<String> Economics=new ArrayList<String>();
        Economics.add("Microeconomics");
        Economics.add("Macroeconomics");

        List<String> Mechanics=new ArrayList<String>();
        Mechanics.add("Kinematics Analysis");

        List<String> Psychology=new ArrayList<String>();
        Psychology.add("Psychological Assessment");

        List<String> Photography=new ArrayList<String>();
        Photography.add("Chromatology");

        proFieldDetail.put("Computer Sciences",ComputerSciences);
        proFieldDetail.put("Design",Design);
        proFieldDetail.put("Economics",Economics);
        proFieldDetail.put("Mechanics",Mechanics);
        proFieldDetail.put("Psychology",Psychology);
        proFieldDetail.put("photography",Photography);

        return proFieldDetail;
    }
}
