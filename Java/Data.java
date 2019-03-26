// License
// Copyright 2007 Hamaad Musharaf Shah
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

import java.io.*;
import java.lang.*;
import java.util.*;

public class Data extends Methods {

    public static void main(String[] args) {
        Random generator = new Random();

        // We will have this many distinct elements/keys.
        int n = 20000;

        float x = 0.0F;

        float[] Keys = new float[n];

        for (int i = 0; i < Keys.length; i++) {
            Keys[i] = x;
            x++;
        }

        // Uniformly distributed data.
        List<Float> Temp_1 = new ArrayList<Float>();

        for (int j = 0; j < Keys.length; j++) {
            for (int i = 0; i < 6; i++) {
                Temp_1.add(Keys[j]);
            }
        }

        Float[] Temp_2 = Temp_1.toArray(new Float[0]);

        float[] Data_U = new float[Temp_2.length];

        for (int i = 0; i < Data_U.length; i++) {
            Data_U[i] = Temp_2[i];
        }


        Output_file_float(Data_U, "Data_U.txt");

        // First 80% of keys occur more frequently than other keys.
        List<Float> Temp_3 = new ArrayList<Float>();

        for (int j = 0; j < Keys.length; j++) {
            for (int i = 0; i < 3; i++) {
                Temp_3.add(Keys[j]);
            }
        }

        Float[] Temp_4 = Temp_3.toArray(new Float[0]);

        float[] Data_80 = new float[Temp_4.length + (3 * n)];

        for (int i = 0; i < Temp_4.length; i++) {
            Data_80[i] = Temp_4[i];
        }

        for (int i = Temp_4.length; i < Data_80.length; i++) {
            int r = generator.nextInt((int) ((4.0 / 5.0) * n));
            Data_80[i] = Keys[r];
        }


        Output_file_float(Data_80, "Data_80.txt");

        // First 60% of keys occur more frequently than other keys.
        List<Float> Temp_5 = new ArrayList<Float>();

        for (int j = 0; j < Keys.length; j++) {
            for (int i = 0; i < 3; i++) {
                Temp_5.add(Keys[j]);
            }
        }

        Float[] Temp_6 = Temp_5.toArray(new Float[0]);

        float[] Data_60 = new float[Temp_6.length + (3 * n)];

        for (int i = 0; i < Temp_6.length; i++) {
            Data_60[i] = Temp_6[i];
        }

        for (int i = Temp_6.length; i < Data_60.length; i++) {
            int r = generator.nextInt((int) ((3.0 / 5.0) * n));
            Data_60[i] = Keys[r];
        }

        Output_file_float(Data_60, "Data_60.txt");

        // First 50% of keys occur more frequently than other keys.
        List<Float> Temp_7 = new ArrayList<Float>();

        for (int j = 0; j < Keys.length; j++) {
            for (int i = 0; i < 3; i++) {
                Temp_7.add(Keys[j]);
            }
        }

        Float[] Temp_8 = Temp_7.toArray(new Float[0]);

        float[] Data_50 = new float[Temp_8.length + (3 * n)];

        for (int i = 0; i < Temp_8.length; i++) {
            Data_50[i] = Temp_8[i];
        }

        for (int i = Temp_8.length; i < Data_50.length; i++) {
            int r = generator.nextInt((int) ((1.0 / 2.0) * n));
            Data_50[i] = Keys[r];
        }


        Output_file_float(Data_50, "Data_50.txt");

        // First 25% of keys occur more frequently than other keys.
        List<Float> Temp_9 = new ArrayList<Float>();

        for (int j = 0; j < Keys.length; j++) {
            for (int i = 0; i < 3; i++) {
                Temp_9.add(Keys[j]);
            }
        }

        Float[] Temp_10 = Temp_9.toArray(new Float[0]);

        float[] Data_25 = new float[Temp_10.length + (3 * n)];

        for (int i = 0; i < Temp_10.length; i++) {
            Data_25[i] = Temp_10[i];
        }

        for (int i = Temp_10.length; i < Data_25.length; i++) {
            int r = generator.nextInt((int) ((1.0 / 4.0) * n));
            Data_25[i] = Keys[r];
        }

        Output_file_float(Data_25, "Data_25.txt");

        // This is a joint variable.
        // We define a mapping such that if the first coordinate has
        // a key of less than 8000, then the second coordinate will
        // be 100.
        // So we should expect some pretty good association.

        float[] Coordinate_1_C = new float[2 * n];
        float[] Coordinate_2_C = new float[2 * n];

        for (int i = 0; i < n; i++) {
            Coordinate_1_C[i] = Keys[i];
        }

        for (int i = n; i < Coordinate_1_C.length; i++) {
            int r = generator.nextInt(n);
            Coordinate_1_C[i] = Keys[r];
        }

        for (int i = 0; i < Coordinate_2_C.length; i++) {
            int s = generator.nextInt(n);
            if (Coordinate_1_C[i] < 8000) Coordinate_2_C[i] = 100;
            else Coordinate_2_C[i] = Keys[s];
        }

        Output_file_float(Coordinate_1_C, "Coordinate_1_C.txt");
        Output_file_float(Coordinate_2_C, "Coordinate_2_C.txt");

        // This is a joint variable.
        // We define a mapping such that there is no
        // association whatsoever between the first and second coordinate.

        float[] Coordinate_1_D = new float[2 * n];
        float[] Coordinate_2_D = new float[2 * n];

        for (int i = 0; i < n; i++) {
            Coordinate_1_D[i] = Keys[i];
        }

        for (int i = n; i < Coordinate_1_D.length; i++) {
            int r = generator.nextInt(n);
            Coordinate_1_D[i] = Keys[r];
        }

        for (int i = 0; i < Coordinate_2_D.length; i++) {
            int s = generator.nextInt(n);
            Coordinate_2_D[i] = Keys[s];
        }

        Output_file_float(Coordinate_1_D, "Coordinate_1_D.txt");
        Output_file_float(Coordinate_2_D, "Coordinate_2_D.txt");
    }

}
