// License
// Copyright 2007 Hamaad Musharaf Shah
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

import java.io.*;

public class IndExp extends Methods {

    public static void main(String[] args) {    // Filenames of data sets.
        String Filename_A = System.getProperty("user.home") + File.separator + "Coordinate_1_A.txt";

        String Filename_B = System.getProperty("user.home") + File.separator + "Coordinate_2_A.txt";

        String Filename_C = System.getProperty("user.home") + File.separator + "Coordinate_1_B.txt";

        String Filename_D = System.getProperty("user.home") + File.separator + "Coordinate_2_B.txt";

        // Data sets.
        float[][] Data_A = Joint_var_float(Read_Data_float(Filename_A), Read_Data_float(Filename_B));

        float[][] Data_B = Joint_var_float(Read_Data_float(Filename_C), Read_Data_float(Filename_D));

        // Distance parameter.
        float e = Float.parseFloat(args[0]);

        // We will have to change the constructor's
        // input to conduct tests on different
        // data sets.
        // I could have easily created different objects, and
        // output the results altogether, but that might have
        // created slight confusion.
        Independence Ind = new Independence(Data_B, 0.05F, e);

        System.out.print("INDEPENDENCE TEST");

        System.out.println("\n");

        System.out.print("The result of the Independence Test with a distance parameter of " + e + " is = " + Ind.Ind());

        System.out.println("\n");

        String Filename_E = System.getProperty("user.home") + File.separator + "Independence_P.txt";

        String Filename_F = System.getProperty("user.home") + File.separator + "Independence_Q.txt";

        long[] Independence_P = Read_Data_long(Filename_E);

        long[] Independence_Q = Read_Data_long(Filename_F);

        System.out.print("CS2 TEST");

        System.out.println("\n");

        CS2 CS2_test = new CS2(Independence_P, Independence_Q);

        double CS2_test_stat = CS2_test.CS2();

        System.out.print("The CS2 test statistic is = " + CS2_test_stat);

        System.out.println("\n");

        if (Math.abs(CS2_test_stat) > 1.96D)
            System.out.print("Thus, at 0.05 alpha, we reject the null hypothesis of independence as the test statistic is larger than the critical value, 1.96");
        else
            System.out.print("Thus, at 0.05 alpha, we accept the null hypothesis of independence as the test statistic is smaller than the critical value 1.96");

        System.out.println("\n");

        System.out.print("KS2 TEST");

        System.out.println("\n");

        KS2 KS2_test = new KS2(Independence_P, Independence_Q);

        double KS2_test_stat = KS2_test.KS2();

        System.out.print("The KS2 test statistic is = " + KS2_test_stat);

        System.out.println("\n");

        double critical_value = (1.36D) * (Math.sqrt((double) (Independence_P.length + Independence_Q.length) / (double) (Independence_P.length * Independence_Q.length)));

        if (KS2_test_stat > critical_value)
            System.out.print("Thus, at 0.05 alpha, we reject the null hypothesis of independence as the test statistic is larger than the critical value, " + critical_value);

        else
            System.out.print("Thus, at 0.05 alpha, we accept the null hypothesis of independence as the test statistic is smaller than the critical value, " + critical_value);
    }

}
