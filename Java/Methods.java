// License
// Copyright 2007 Hamaad Musharaf Shah
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

import java.io.*;
import java.lang.*;
import java.util.*;

public class Methods {

    // This method is used to read in data from files
// and outputs it as a int array.
    public static int[] Read_Data_int(String Filename) {
        int[] Data = null;

        // http://groups.google.com/group/comp.lang.java.help/browse_thread/thread/72008b53ab794fb7/10f4e15b26559849?lnk=raot
        //  Accessed on 7 July 2007.
        try {
            List<String> lines = new LinkedList<String>();
            FileReader fileReader = new FileReader(Filename);
            LineNumberReader reader = new LineNumberReader(fileReader);
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
            String[] Temp_Array = lines.toArray(new String[0]);
            Data = new int[Temp_Array.length];
            for (int i = 0; i < Data.length; i++) {
                Data[i] = Integer.parseInt(Temp_Array[i]);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return Data;
    }

    // This method is used to read in data from files
// and outputs it as a long array.
    public static long[] Read_Data_long(String Filename) {
        long[] Data = null;

        // http://groups.google.com/group/comp.lang.java.help/browse_thread/thread/72008b53ab794fb7/10f4e15b26559849?lnk=raot
        //  Accessed on 7 July 2007.
        try {
            List<String> lines = new LinkedList<String>();
            FileReader fileReader = new FileReader(Filename);
            LineNumberReader reader = new LineNumberReader(fileReader);
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
            String[] Temp_Array = lines.toArray(new String[0]);
            Data = new long[Temp_Array.length];
            for (int i = 0; i < Data.length; i++) {
                Data[i] = Long.parseLong(Temp_Array[i]);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return Data;
    }

    // This method is used to read in data from files
// and outputs it as a float array.
    public static float[] Read_Data_float(String Filename) {
        float[] Data = null;

        // http://groups.google.com/group/comp.lang.java.help/browse_thread/thread/72008b53ab794fb7/10f4e15b26559849?lnk=raot
        //  Accessed on 7 July 2007.
        try {
            List<String> lines = new LinkedList<String>();
            FileReader fileReader = new FileReader(Filename);
            LineNumberReader reader = new LineNumberReader(fileReader);
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
            String[] Temp_Array = lines.toArray(new String[0]);
            Data = new float[Temp_Array.length];
            for (int i = 0; i < Data.length; i++) {
                Data[i] = Float.parseFloat(Temp_Array[i]);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return Data;
    }

    // This method is used to read in data from files
// and outputs it as a String array.
    public static String[] Read_Data_string(String Filename) {
        String[] Data = null;

        // http://groups.google.com/group/comp.lang.java.help/browse_thread/thread/72008b53ab794fb7/10f4e15b26559849?lnk=raot
        //  Accessed on 7 July 2007.
        try {
            List<String> lines = new LinkedList<String>();
            FileReader fileReader = new FileReader(Filename);
            LineNumberReader reader = new LineNumberReader(fileReader);
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
            Data = lines.toArray(new String[0]);
        } catch (IOException e) {
            System.out.println(e);
        }

        return Data;
    }

    // This method is used to find the frequency of
// an element at index i in a data set.
// The data set is of int[] type.
    public static int Freq_index_int(int[] Data, int i) {
        int Freq = 0;

        int k = i;

        while (k == i) {
            for (int j = 0; j < Data.length; j++) {
                if (Data[k] == Data[j]) Freq += 1;
                else Freq = Freq;
            }
            break;
        }

        return Freq;
    }

    // This method is used to find the frequency of
// a particular element in the data set.
// The data set is of int[] type.
    public static int Freq_element_int(int[] Data, int x) {
        int Freq = 0;

        for (int i = 0; i < Data.length; i++) {
            if (Data[i] == x) Freq += 1;
            else Freq = Freq;
        }

        return Freq;
    }

    // This method is used to find the frequency of
// an element at index i in a data set.
// The data set if of long[] type.
    public static int Freq_index_long(long[] Data, int i) {
        int Freq = 0;

        int k = i;

        while (k == i) {
            for (int j = 0; j < Data.length; j++) {
                if (Data[k] == Data[j]) Freq += 1;
                else Freq = Freq;
            }
            break;
        }

        return Freq;
    }

    // This method is used to find the frequency of
// a particular element in the data set.
// The data set if of long[] type.
    public static int Freq_element_long(long[] Data, long x) {
        int Freq = 0;

        for (int i = 0; i < Data.length; i++) {
            if (Data[i] == x) Freq += 1;
            else Freq = Freq;
        }

        return Freq;
    }

    // This method is used to find the frequency distribution of a data set.
// The data set is of int[] type.
    public static int[] Frequency_vector_int(int[] Data) {
        Integer[] temp = new Integer[Data.length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = Data[i];
        }

        // http://java.sun.com/j2se/1.5.0/docs/guide/language/autoboxing.html
        // Accessed on 28 June 2007.
        Map<Integer, Integer> M = new TreeMap<Integer, Integer>();
        for (Integer A : temp) {
            Integer Freq = M.get(A);
            M.put(A, (Freq == null ? 1 : Freq + 1));
        }

        Integer[] Freq_Values = M.values().toArray(new Integer[0]);
        int[] Ans = new int[Freq_Values.length];

        for (int i = 0; i < Ans.length; i++) {
            Ans[i] = Freq_Values[i];
        }

        return Ans;
    }

    // This method is used to find the frequency distribution of a data set.
// The data set is of float[] type.
    public static float[] Frequency_vector_float(float[] Data) {
        Float[] temp = new Float[Data.length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = Data[i];
        }

        // http://java.sun.com/j2se/1.5.0/docs/guide/language/autoboxing.html
        // Accessed on 28 June 2007.
        Map<Float, Float> M = new TreeMap<Float, Float>();
        for (Float A : Data) {
            Float Freq = M.get(A);
            M.put(A, (Freq == null ? 1 : Freq + 1));
        }

        Float[] Freq_Values = M.values().toArray(new Float[0]);
        float[] Ans = new float[Freq_Values.length];

        for (int i = 0; i < Ans.length; i++) {
            Ans[i] = Freq_Values[i];
        }

        return Ans;
    }

    // This method is used to find the frequency distribution of a data set for string data.
// The data set if of String[] type.
    public static float[] Frequency_vector_string(String[] Data) {    // http://java.sun.com/j2se/1.5.0/docs/guide/language/autoboxing.html
        // Accessed on 28 June 2007.
        Map<String, Float> M = new TreeMap<String, Float>();
        for (String A : Data) {
            Float Freq = M.get(A);
            M.put(A, (Freq == null ? 1 : Freq + 1));
        }

        Float[] Freq_Values = M.values().toArray(new Float[0]);
        float[] Ans = new float[Freq_Values.length];

        for (int i = 0; i < Ans.length; i++) {
            Ans[i] = Freq_Values[i];
        }

        return Ans;
    }

    // This method is used to find the probability distribution of a data set.
// The data set is of int[] type. 
    public static float[] Probability_vector_int(int[] Data) {
        int Sum = Data.length;

        float[] Prob = new float[Frequency_vector_int(Data).length];

        for (int i = 0; i < Prob.length; i++) {
            Prob[i] = (float) ((float) Frequency_vector_int(Data)[i] / (float) Sum);
        }

        return Prob;
    }

    // This method is used to find the probability distribution of a data set.
// The data set is of float[] type. 
    public static float[] Probability_vector_float(float[] Data) {
        int Sum = Data.length;

        float[] Prob = new float[Frequency_vector_float(Data).length];

        for (int i = 0; i < Prob.length; i++) {
            Prob[i] = (float) Frequency_vector_float(Data)[i] / (float) Sum;
        }

        return Prob;
    }

    // This method is used to sample m elements from a data set.
    public static int[] Sample(int[] Data, int m) {
        Random generator = new Random();

        int[] Sample = new int[m];

        for (int i = 0; i < Sample.length; i++) {
            int rand = generator.nextInt(Data.length);
            Sample[i] = Data[rand];
        }

        return Sample;
    }

    // This method is a variation of the Sample(...) method above
// and is used in the closeness test.
    public static int[] Sample_light(int[] Data, int[] S, int m) {
        Random generator = new Random();

        int[] Sample = new int[m];

        int[] Keys = Keys_table_int(Data);

        int[] N = new int[Keys.length];

        int x = 1;

        for (int i = 0; i < N.length; i++) {
            N[i] = x;
            x++;
        }

        for (int i = 0; i < Sample.length; i++) {
            int rand = generator.nextInt(Data.length);
            Sample[i] = Data[rand];
            for (int j = 0; j < S.length; j++) {
                int r = generator.nextInt(Keys.length);
                int n = N[r];
                if (Sample[i] != S[j]) Sample[i] = Sample[i];
                else Sample[i] = n;
            }
        }

        return Sample;
    }

    // This method is used to sample m elements from a data set
// for the independence algorithm. 
    public static long[] Sample_for_ind(long[] Data, int m) {
        Random generator = new Random();

        long[] Sample = new long[m];

        for (int i = 0; i < Sample.length; i++) {
            int rand = generator.nextInt(Data.length);
            Sample[i] = Data[rand];
        }

        return Sample;
    }

    // This method is a variation of the Sample_for_ind(...) method above
// and is used in the independence algorithm.
    public static long[] Sample_light_for_ind_1(long[] Data, long[] S, int m) {
        Random generator = new Random();

        long[] Sample = new long[m];

        long[] Keys = Keys_table_long(Data);

        int[] N = new int[Keys.length];

        int x = 1;

        for (int i = 0; i < N.length; i++) {
            N[i] = x;
            x++;
        }

        for (int i = 0; i < Sample.length; i++) {
            int rand = generator.nextInt(Data.length);
            Sample[i] = Data[rand];
            for (int j = 0; j < S.length; j++) {
                int r = generator.nextInt(Keys.length);
                int n = N[r];
                if (Sample[i] != S[j]) Sample[i] = Sample[i];
                else Sample[i] = (long) n;
            }
        }

        return Sample;
    }

    // This method is a variation of the Sample_for_ind(...) method above
// and is used in the independence algorithm.
    public static long[] Sample_light_for_ind_2(long[] Data, long[] S, int[][] A, int m) {
        Random generator = new Random();

        long[] Sample = new long[m];

        long[] Keys = Keys_table_long(Data);

        int[] N = new int[Keys.length];

        int x = 1;

        for (int i = 0; i < N.length; i++) {
            N[i] = x;
            x++;
        }

        for (int i = 0; i < Sample.length; i++) {
            Sample[i] = conversion(joint_ind_sample(A, 1))[0];
            for (int j = 0; j < S.length; j++) {
                int r = generator.nextInt(Keys.length);
                int n = N[r];
                if (Sample[i] != S[j]) Sample[i] = Sample[i];
                else Sample[i] = (long) n;
            }
        }

        return Sample;
    }

    // This method is used to estimate the self-collision probabilities
// in the closeness and identity algorithm.
    public static int Self_col_prob(int[] x) {
        int Ans = 0;

        int i = 0;

        int k = i + 1;

        for (i = 0; i < x.length; i++) {
            for (k = i + 1; k < x.length; k++) {
                if (x[i] == x[k]) Ans += 1;
                else Ans += 0;
            }
        }

        return Ans;
    }

    // This method is used to estimate the collision probabilities
// in the closeness algorithm.
    public static int Col_prob(int[] x, int[] y) {
        int Ans = 0;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (x[i] == y[j]) Ans += 1;
                else Ans += 0;
            }
        }

        return Ans;
    }

    // This method is used to estimate the self-collision probabilities
// for the independence algorithm.
    public static int Self_col_prob_for_ind(long[] x) {
        int Ans = 0;

        int i = 0;

        int k = i + 1;

        for (i = 0; i < x.length; i++) {
            for (k = i + 1; k < x.length; k++) {
                if (x[i] == x[k]) Ans += 1;
                else Ans += 0;
            }
        }

        return Ans;
    }

    // This method is used to estimate the collision probabilities
// for the independence algorithm.
    public static int Col_prob_for_ind(long[] x, long[] y) {
        int Ans = 0;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (x[i] == y[j]) Ans += 1;
                else Ans += 0;
            }
        }

        return Ans;
    }

    // This method is used for the bucketing technique in the identity test.
    public static int[] Bucket(float[] X, float e, int n, int i) {    // http://java.sun.com/docs/books/tutorial/collections/interfaces/collection.html
        // Accessed on 15 July 2007.
        List<Integer> List = new ArrayList<Integer>();

        for (int j = 0; j < X.length; j++) {
            if (i == 0 && X[j] < (float) (1 / (n * Math.log(n)))) List.add(j);
            else if (X[j] >= (float) ((Math.pow(1 + e, i - 1)) / (n * Math.log(n))) && X[j] < (float) ((Math.pow(1 + e, i)) / (n * Math.log(n))))
                List.add(j);
        }

        Integer[] temp = List.toArray(new Integer[0]);
        int[] Ans = new int[temp.length];

        for (int j = 0; j < Ans.length; j++) {
            Ans[j] = temp[j];
        }

        return Ans;
    }

    // This method is used to find the intersection of two sets.
// It is used in the identity algorithm.
    public static int[] Intersect(int[] M, int[] X) {    // http://java.sun.com/docs/books/tutorial/collections/interfaces/collection.html
        // Accessed on 15 July 2007.

        // http://forum.java.sun.com/thread.jspa?threadID=450002&messageID=2042326
        // Accessed on 17 July 2007.

        // p.229 Java in a nutshell.
        Integer[] m = new Integer[M.length];
        Integer[] x = new Integer[X.length];

        for (int i = 0; i < M.length; i++) {
            m[i] = M[i];
        }

        for (int i = 0; i < X.length; i++) {
            x[i] = X[i];
        }

        List<Integer> z = new ArrayList<Integer>(Arrays.asList(m));

        // p.229-230 Java in a nutshell.
        List<Integer> c = new ArrayList<Integer>(Arrays.asList(x));

        if (M.length < X.length) c.retainAll(z);
        else z.retainAll(c);

        Integer[] temp = null;

        if (M.length < X.length) temp = c.toArray(new Integer[0]);
        else temp = z.toArray(new Integer[0]);

        int[] Ans = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            Ans[i] = temp[i];
        }

        return Ans;
    }

    // This method is used to get an array of those
// elements of A that do not occur in B.
// It is used in the Chi-square two sample test.
    public static int[] Uncommon(int[] A, int[] B) {
        List<Integer> Common = new ArrayList<Integer>();

        for (int i = 0; i < A.length; i++) {
            Common.add((int) A[i]);
        }

        for (int i = 0; i < B.length; i++) {
            Common.add((int) B[i]);
        }

        List<Integer> CA = new ArrayList<Integer>();

        for (int i = 0; i < A.length; i++) {
            CA.add((int) A[i]);
        }

        Common.removeAll(CA);

        Integer[] C = Common.toArray(new Integer[0]);
        int[] Cmn = new int[C.length];

        for (int i = 0; i < Cmn.length; i++) {
            Cmn[i] = C[i];
        }

        return Cmn;
    }

    // This method is used to produce an array which contains
// the distinct elements of a int[] type data set. 
    public static int[] Keys_table_int(int[] Data) {
        Integer[] temp = new Integer[Data.length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = Data[i];
        }

        // http://java.sun.com/j2se/1.5.0/docs/guide/language/autoboxing.html
        // Accessed on 28 June 2007.
        Map<Integer, Integer> M = new TreeMap<Integer, Integer>();
        for (Integer A : temp) {
            Integer Freq = M.get(A);
            M.put(A, (Freq == null ? 1 : Freq + 1));
        }

        Integer[] Keys = M.keySet().toArray(new Integer[0]);

        int[] Ans = new int[Keys.length];

        for (int i = 0; i < Ans.length; i++) {
            Ans[i] = Keys[i];
        }

        return Ans;
    }

    // This method is used to produce an array which contains
// the distinct elements of a long[] type data set.
    public static long[] Keys_table_long(long[] Data) {
        Long[] temp = new Long[Data.length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = Data[i];
        }

        // http://java.sun.com/j2se/1.5.0/docs/guide/language/autoboxing.html
        // Accessed on 28 June 2007.
        Map<Long, Integer> M = new TreeMap<Long, Integer>();
        for (Long A : temp) {
            Integer Freq = M.get(A);
            M.put(A, (Freq == null ? 1 : Freq + 1));
        }

        Long[] Keys = M.keySet().toArray(new Long[0]);

        long[] Ans = new long[Keys.length];

        for (int i = 0; i < Ans.length; i++) {
            Ans[i] = Keys[i];
        }

        return Ans;
    }

    // This method is used to produce an array which contains
// the distinct elements of a float[] type data set. 
    public static float[] Keys_table_float(float[] Data) {
        Float[] temp = new Float[Data.length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = Data[i];
        }

        // http://java.sun.com/j2se/1.5.0/docs/guide/language/autoboxing.html
        // Accessed on 28 June 2007.
        Map<Float, Integer> M = new TreeMap<Float, Integer>();
        for (Float A : temp) {
            Integer Freq = M.get(A);
            M.put(A, (Freq == null ? 1 : Freq + 1));
        }

        Float[] Keys = M.keySet().toArray(new Float[0]);

        float[] Ans = new float[Keys.length];

        for (int i = 0; i < Ans.length; i++) {
            Ans[i] = Keys[i];
        }

        return Ans;
    }

    // This method is used to produce an array which contains
// the distinct elements of a String[] type data set. 
    public static String[] Keys_table_string(String[] Data) {    // http://java.sun.com/j2se/1.5.0/docs/guide/language/autoboxing.html
        // Accessed on 28 June 2007.
        Map<String, Integer> M = new TreeMap<String, Integer>();
        for (String A : Data) {
            Integer Freq = M.get(A);
            M.put(A, (Freq == null ? 1 : Freq + 1));
        }

        String[] Keys = M.keySet().toArray(new String[0]);

        return Keys;
    }

    // This method is used to compute the
// cumulative frequency distribution.
    public static int[] Cumulative_freq(int[] Data) {
        int[] C_freq = Frequency_vector_int(Data);

        int[] Ans = new int[C_freq.length];

        Ans[0] = C_freq[0];

        for (int i = 1; i < C_freq.length; i++) {
            Ans[i] = C_freq[i] + Ans[i - 1];
        }

        return Ans;
    }

    // This method is used to compute the
// cumulative probability distribution.
    public static float[] CDF(int[] C_freq, int n) {
        float[] Ans = new float[C_freq.length];

        for (int i = 0; i < Ans.length; i++) {
            Ans[i] = (float) C_freq[i] / (float) n;
        }

        return Ans;
    }

    // This method is used to simply obtain the element
// with the maximum value from a float[] type array.
    public static double Max(double[] Data) {    // http://www.leepoint.net/notes-java/data/arrays/arrays-ex-max.html
        // Accessed on 22nd July 2007.
        double Maximum = Data[0];

        for (int i = 1; i < Data.length; i++) {
            if (Data[i] > Maximum) {
                Maximum = Data[i];
            }
        }

        return Maximum;
    }

    // This method is used to code two sets of 1-dimensional arrays
// as a single 2-dimensional array; works on int type.
    public static int[][] Joint_var_int(int[] A, int[] B) {
        int[][] Ans = new int[A.length][2];

        for (int i = 0; i < Ans.length; i++) {
            Ans[i][0] = A[i];
            Ans[i][1] = B[i];
        }

        return Ans;
    }

    // This method is used to code two sets of 1-dimensional arrays
// as a single 2-dimensional array; works on float type.
    public static float[][] Joint_var_float(float[] A, float[] B) {
        float[][] Ans = new float[A.length][2];

        for (int i = 0; i < Ans.length; i++) {
            Ans[i][0] = A[i];
            Ans[i][1] = B[i];
        }

        return Ans;
    }

    // This method is used to code two sets of 1-dimensional arrays
// as a single 2-dimensional array; works on String type.
    public static String[][] Joint_var_string(String[] A, String[] B) {
        String[][] Ans = new String[A.length][2];

        for (int i = 0; i < Ans.length; i++) {
            Ans[i][0] = A[i];
            Ans[i][1] = B[i];
        }

        return Ans;
    }

    // This method is used to find the row and column totals
// in the Chi-square two sample test.
    public static int[][] R_C_totals(int[][][] A, String Dimension) {
        int[][] Ans_1 = new int[2][1];

        int[][] Ans_2 = new int[A[0].length][1];

        if (Dimension == "Rows") {
            for (int j = 0; j < A[0].length; j++) {
                Ans_1[0][0] += A[0][j][0];
            }

            for (int j = 0; j < A[1].length; j++) {
                Ans_1[1][0] += A[1][j][1];
            }
        } else {
            for (int j = 0; j < Ans_2.length; j++) {
                Ans_2[j][0] = A[0][j][0] + A[1][j][1];

            }
        }

        if (Dimension == "Rows") return Ans_1;
        else return Ans_2;
    }

    // This method converts a pair of int numbers to a single unique long number.
// It basically converts an int[][] array to a long[] array.
// http://people.clarkson.edu/~whesse/cs643/assignments/assignment_2.html
// Accessed on 17 Aug 07.
    public static long[] conversion(int[][] A) {
        long[] Ans = new long[A.length];

        for (int i = 0; i < Ans.length; i++) {
            Ans[i] = (long) (A[i][1] * Math.pow(2, 32)) + (long) A[i][0];
        }

        return Ans;
    }

    // This method takes samples from a
// probability distribution over a pair of sets.
    public static int[][] joint_sample(int[][] X, int m) {
        int[][] Ans = new int[m][2];

        Random generator = new Random();

        for (int i = 0; i < m; i++) {
            int r = generator.nextInt(X.length);
            Ans[i][0] = X[r][0];
            Ans[i][1] = X[r][1];
        }

        return Ans;
    }

    // This method simulates samples from
// the product of the marginal distributions.
    public static int[][] joint_ind_sample(int[][] X, int m) {
        int[][] Ind_X = new int[m][2];

        for (int i = 0; i < m; i++) {
            int[][] sample_1 = joint_sample(X, 1);
            int[][] sample_2 = joint_sample(X, 1);

            Ind_X[i][0] = sample_1[0][0];
            Ind_X[i][1] = sample_2[0][1];
        }

        return Ind_X;
    }

    // This method is used to output
// int data to a file.
// Flanagan, (2005), p.255.
    public static void Output_file_int(int[] Data, String File_name) {
        try {
            File f = new File(System.getProperty("user.home"), File_name);
            PrintWriter out = new PrintWriter(new FileWriter(f));
            for (int i = 0; i < Data.length; i++) {
                out.println(Data[i]);
            }
            out.close();
        } catch (IOException e) {
        }
    }

    // This method is used to output long data
// to a file in double.
// Flanagan, (2005), p.255.
    public static void Output_file_long(long[] Data, String File_name) {
        try {
            File f = new File(System.getProperty("user.home"), File_name);
            PrintWriter out = new PrintWriter(new FileWriter(f));
            for (int i = 0; i < Data.length; i++) {
                out.println(Data[i]);
            }
            out.close();
        } catch (IOException e) {
        }
    }

    // This method is used to output float
// data to a file.
// Flanagan, (2005), p.255.
    public static void Output_file_float(float[] Data, String File_name) {
        try {
            File f = new File(System.getProperty("user.home"), File_name);
            PrintWriter out = new PrintWriter(new FileWriter(f));
            for (int i = 0; i < Data.length; i++) {
                out.println(Data[i]);
            }
            out.close();
        } catch (IOException e) {
        }
    }

    // This method is used to output String
// data to a file.
// Flanagan, (2005), p.255.
    public static void Output_file_string(String[] Data, String File_name) {
        try {
            File f = new File(System.getProperty("user.home"), File_name);
            PrintWriter out = new PrintWriter(new FileWriter(f));
            for (int i = 0; i < Data.length; i++) {
                out.println(Data[i]);
            }
            out.close();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
    }

}
