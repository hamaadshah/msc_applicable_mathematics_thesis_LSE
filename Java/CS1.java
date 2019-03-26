// License
// Copyright 2007 Hamaad Musharaf Shah
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

import java.io.*;
import java.lang.*;
import java.util.*;

public class CS1 extends Methods {

    public int[] Obs;

    public float[] Theo;

    public CS1(int[] I, float[] Theo) {
        this.Obs = I;
        this.Theo = Theo;
    }

    public CS1(float[] F, float[] Theo) {
        float[] F_keys = Keys_table_float(F);
        int[] I_keys = new int[F_keys.length];

        int n = 0;

        for (int i = 0; i < I_keys.length; i++) {
            I_keys[i] = n;
            n++;
        }

        int[] I = new int[F.length];

        for (int i = 0; i < I.length; i++) {
            for (int j = 0; j < I_keys.length; j++) {
                if (F[i] == F_keys[j]) I[i] = I_keys[j];
            }
        }

        this.Obs = I;
        this.Theo = Theo;
    }

    public CS1(String[] S, float[] Theo) {
        String[] S_keys = Keys_table_string(S);

        int[] I_keys = new int[S_keys.length];

        int n = 0;

        for (int i = 0; i < I_keys.length; i++) {
            I_keys[i] = n;
            n++;
        }

        int[] I = new int[S.length];

        for (int i = 0; i < I.length; i++) {
            for (int j = 0; j < I_keys.length; j++) {
                if (S[i] == S_keys[j]) I[i] = I_keys[j];
            }
        }

        this.Obs = I;
        this.Theo = Theo;
    }

    public double CS1() {
        int[] Obs_freq = Frequency_vector_int(Obs);

        double Ans = 0.0D;

        for (int i = 0; i < Obs_freq.length; i++) {
            Ans += (double) (Math.pow(Obs_freq[i] - Theo[i], 2)
                    / (double) (Theo[i]));
        }

        double DoF = (double) (Obs_freq.length - 1);

        // http://fonsg3.let.uva.nl/Service/Statistics/X2Test.html
        // Accessed on 23 July 2007.
        double z = (double) ((Math.pow((Ans / DoF), 1.0D / 3.0D) - (1.0D - (2.0D / (9.0D * DoF)))) / (double) (Math.sqrt(2.0D / (9.0D * DoF))));

        if (DoF > 30.0D) return z;
        else return Ans;
    }

    public static void main(String[] args) {
    }

}
