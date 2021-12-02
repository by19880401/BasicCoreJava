package com.objectiva.decmethod;

import com.objectiva.definition.LaborLevelDefinition;

public class StaticDecomposeLaborAccountNameDemo {

    public static void main(String[] args) {
        String[] strArr = decomposeLaborAccountName("LaborAccount");
        System.out.println(strArr);
    }


    public static String[] decomposeLaborAccountName(String name, Integer laborLevels) {
        if (name==null || name.trim().isEmpty()) {
            return new String[]{};
        }

        if (null == laborLevels) {
            laborLevels = LaborLevelDefinition.getNumOfCategories();
        }

        String[] entries = new String[LaborLevelDefinition.MAX_NUMBER_OF_LEVELS];
        int count = 0;
        String laName = name;

        //support new style labor category account string (comma separated)
        char delim = ',';
        if (name.contains("/")) {
            delim = '/';
        }

        while (name.length() != 0) {
            int index = name.indexOf(delim);
            if (index == -1) {
                entries[count] = name;
                break;
            }
            if (index == 0) {
                entries[count] = null;
            }
            else {
                entries[count] = name.substring(0, index);
            }
            name = name.substring(index + 1);
            count++;

            if (count==0 && laborLevels==0) {
                //no labor levels defined and and empty account '////' or ',,,,' was provided
                return new String[]{};
            }

            //Make sure that the number of labor levels is no larger than defined number
            if (count > (laborLevels - 1)) {
                throw new RuntimeException("haha1");
            }
        } //while

        // Look at the number of levels defined not the maximum
//    if (count != laborLevels - 1) {
//      if (Log.priorityEnabled(LaborLevelPackageManager.getLaborLevelPackageLogContext(), Log.DEBUG))
//        Log.log(LaborLevelPackageManager.getLaborLevelPackageLogContext(), Log.DEBUG,
//                "LAcct-decomposeLaborAccountName != laName=" + laName + " name=" + name
//                + " count=" + count + " laborLevels=" + laborLevels);
//      throw LaborLevelProcessingException.invalidLaborAccountNameLevels(laName, Integer.toString(laborLevels));
//    }
        return entries;
    }

    public static String[] decomposeLaborAccountName(String name) {
        return decomposeLaborAccountName(name, null);
    }
}
