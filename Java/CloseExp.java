// License
// Copyright 2007 Hamaad Musharaf Shah
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

import java.io.*;

public class CloseExp extends Methods {

    public static void main(String[] args) {    // Data set filenames.
        String Filename_A = System.getProperty("user.home") + File.separator + "Data_25.txt";

        String Filename_B = System.getProperty("user.home") + File.separator + "Data_50.txt";

        String Filename_C = System.getProperty("user.home") + File.separator + "Data_60.txt";

        String Filename_D = System.getProperty("user.home") + File.separator + "Data_80.txt";

        // Data sets.
        float[] Data_25 = Read_Data_float(Filename_A);

        float[] Data_50 = Read_Data_float(Filename_B);

        float[] Data_60 = Read_Data_float(Filename_C);

        float[] Data_80 = Read_Data_float(Filename_D);

        // Distance parameter.
        float e = Float.parseFloat(args[0]);

        // We will have to change the constructor's
        // input to conduct tests on different
        // data sets.
        // I could have easily created different objects, and
        // output the results altogether, but that might have
        // created slight confusion.
        Closeness Close = new Closeness(Data_25, Data_80, 0.05F, e);

        System.out.print("CLOSENESS TEST");

        System.out.println("\n");

        System.out.print("The result of the Closeness test with a distance parameter of "
                + e + " is = " + Close.Closeness());

        System.out.println("\n");

        String Filename_E = System.getProperty("user.home") + File.separator + "Closeness_P.txt";

        String Filename_F = System.getProperty("user.home") + File.separator + "Closeness_Q.txt";

        int[] Closeness_P = Read_Data_int(Filename_E);

        int[] Closeness_Q = Read_Data_int(Filename_F);

        System.out.print("CS2 TEST");

        System.out.println("\n");

        CS2 CS2_test = new CS2(Closeness_P, Closeness_Q);

        double CS2_test_stat = CS2_test.CS2();

        System.out.print("The CS2 test statistic is = " + CS2_test_stat);

        System.out.println("\n");

        if (Math.abs(CS2_test_stat) > 1.96D)
            System.out.print("Thus, at 0.05 alpha, we reject the null hypothesis that the two distributions are similar as the test statistic is larger than the critical value, 1.96");
        else
            System.out.print("Thus, at 0.05 alpha, we accept the null hypothesis that the two distributions are similar as the test statistic is smaller than the critical value, 1.96");

        System.out.println("\n");

        System.out.print("KS2 TEST");

        System.out.println("\n");

        KS2 KS2_test = new KS2(Closeness_P, Closeness_Q);

        double KS2_test_stat = KS2_test.KS2();

        System.out.print("The KS2 test statistic is = " + KS2_test_stat);

        System.out.println("\n");

        double critical_value = (1.36D) * (Math.sqrt((double) (Closeness_P.length + Closeness_Q.length) / (double) (Closeness_P.length * Closeness_Q.length)));
        if (KS2_test_stat > critical_value)
            System.out.print("Thus, at 0.05 alpha, we reject the null hypothesis that the two distributions are similar as the test statistic is larger than the critical value, " + critical_value);
        else
            System.out.print("Thus, at 0.05 alpha, we accept the null hypothesis that the two distributions are similar as the test statistic is smaller than the critical value, " + critical_value);
    }

}
