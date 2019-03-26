// License
// Copyright 2007 Hamaad Musharaf Shah
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

import java.io.*;

public class IdExp extends Methods {

    public static void main(String[] args) {    // Filenames of the data sets.
        String Filename_A = System.getProperty("user.home") + File.separator + "Data_U.txt";

        String Filename_B = System.getProperty("user.home") + File.separator + "Data_25.txt";

        // The data sets.
        float[] Data_U = Read_Data_float(Filename_A);

        float[] Data_25 = Read_Data_float(Filename_B);

        // Distance parameter.
        float e = Float.parseFloat(args[0]);

        // Our explicit distribution Y is a uniform distribution.
        float[] Y = new float[Keys_table_float(Data_U).length];

        for (int i = 0; i < Y.length; i++) {
            Y[i] = (float) (1.0 / Y.length);
        }

        // We will have to change the constructor's
        // input to conduct tests on different
        // data sets.
        // I could have easily created different objects, and
        // output the results altogether, but that might have
        // created slight confusion.
        Identity Id = new Identity(Data_U, Y, 0.05F, e);

        System.out.print("IDENTITY TEST");

        System.out.println("\n");

        System.out.print("The result of the Identity Test with a distance parameter of " + e + " is = " + Id.Identity());

        System.out.println("\n");

        String Filename_C = System.getProperty("user.home") + File.separator + "Identity.txt";

        int[] Identity = Read_Data_int(Filename_C);

        System.out.print("CS1 TEST");

        System.out.println("\n");

        // Our theoretical distribution is a uniform distribution.
        float[] Theo = new float[Keys_table_int(Identity).length];

        for (int i = 0; i < Theo.length; i++) {
            Theo[i] = (float) (Identity.length / Keys_table_int(Identity).length);
        }

        CS1 CS1_test = new CS1(Identity, Theo);

        double CS1_test_stat = CS1_test.CS1();

        System.out.print("The CS1 test statistic is = " + CS1_test_stat);

        System.out.println("\n");

        if (Math.abs(CS1_test_stat) > 1.96D)
            System.out.print("Thus, at 0.05 alpha, we reject the null hypothesis that the unknown distribution is uniform as the test statistic is larger than the critical value, 1.96");
        else
            System.out.print("Thus, at 0.05 alpha, we accept the null hypothesis that the unknown distribution is uniform as the test statistic is smaller than the critical value, 1.96");

        System.out.println("\n");

        System.out.print("KS1 TEST");

        System.out.println("\n");

        // Our theoretical distribution is a uniform cumulative distribution.
        float[] Temp = new float[Keys_table_int(Identity).length];

        for (int i = 0; i < Temp.length; i++) {
            Temp[i] = (float) (1.0F / (float) Keys_table_int(Identity).length);
        }

        float[] Theoretical = new float[Temp.length];

        Theoretical[0] = Temp[0];

        for (int i = 1; i < Theo.length; i++) {
            Theoretical[i] = Temp[i] + Theoretical[i - 1];
        }

        KS1 KS1_test = new KS1(Identity, Theoretical);

        double KS1_test_stat = KS1_test.KS1();

        System.out.print("The KS1 test statistic is = " + KS1_test_stat);

        System.out.println("\n");

        double critical_value = (1.36D) / (double) (Math.sqrt(Identity.length));

        if (KS1_test_stat > critical_value)
            System.out.print("Thus, at 0.05 alpha, we reject the null hypothesis that the distribution is uniform similar as the test statistic is larger than the critical value, " + critical_value);

        else
            System.out.print("Thus, at 0.05 alpha, we accept the null hypothesis that the distribution is uniform as the test statistic is smaller than the critical value, " + critical_value);
    }

}
