/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ljs;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.EOFException;

/**
 *Every Object should extend Obj
 */
public class Obj
{
    /*public static double[] doubleArr(double...arr){return arr;}
    public static int[] intArr(int...arr){return arr;}
    public static boolean[] booleanArr(boolean...arr){return arr;}
    public static long[] longArr(long...arr){return arr;}
    public static String[] stringArr(String...arr){return arr;}
    public static Object[] objectArr(Object...arr){return arr;}*/
    
    /*
    Generic types will be infered
    */
	@SuppressWarnings("unchecked")
    public static <E> E[] array(E...e){return e;}
    public static int[] intArray(int...e){return e;}
    public static double[] doubleArray(double...e){return e;}
    public static char[] charArray(char...e){return e;}
    public static long[] longArray(long...e){return e;}
    public static boolean[] booleanArray(boolean...e){return e;}
    
    /*
    Generic types will be infered
    */
	@SuppressWarnings("unchecked")
    public static <E> ArrayList<E> arrayList(E...arr)
    {
        ArrayList<E> ret = new ArrayList<>();
        for(E e : arr)
        {
            ret.add(e);
        }
        return ret;
    }
    public static ArrayList<Integer> intArrayList(int...arr){ArrayList<Integer> ret = new ArrayList<>();for(int i : arr){ret.add(i);}return ret;}
    public static ArrayList<Double> doubleArrayList(double...arr){ArrayList<Double> ret = new ArrayList<>();for(double i : arr){ret.add(i);}return ret;}
    public static ArrayList<Character> charArrayList(char...arr){ArrayList<Character> ret = new ArrayList<>();for(char i : arr){ret.add(i);}return ret;}
    public static ArrayList<Long> longArrayList(long...arr){ArrayList<Long> ret = new ArrayList<>();for(long i : arr){ret.add(i);}return ret;}
    public static ArrayList<Boolean> booleanArrayList(boolean...arr){ArrayList<Boolean> ret = new ArrayList<>();for(boolean i : arr){ret.add(i);}return ret;}
	@SuppressWarnings("unchecked")
    public static <E> LinkedList<E> linkedList(E...arr)
    {
        LinkedList<E> ret = new LinkedList<>();
        for(E e : arr)
        {
            ret.add(e);
        }
        return ret;
    }
    
    public static int[] toIntArray(List<Integer> arr){int[] ret = new int[arr.size()];for(int i = 0; i < arr.size(); i++)ret[i] = arr.get(i);return ret;}
    public static double[] toDoubleArray(List<Double> arr){double[] ret = new double[arr.size()];for(int i = 0; i < arr.size(); i++)ret[i] = arr.get(i);return ret;}
    public static boolean[] toBooleanArray(List<Boolean> arr){boolean[] ret = new boolean[arr.size()];for(int i = 0; i < arr.size(); i++)ret[i] = arr.get(i);return ret;}
    public static String[] toStringArray(List<String> arr){String[] ret = new String[arr.size()];for(int i = 0; i < arr.size(); i++)ret[i] = arr.get(i);return ret;}
    public static long[] toLongArray(List<Long> arr){long[] ret = new long[arr.size()];for(int i = 0; i < arr.size(); i++)ret[i] = arr.get(i);return ret;}
    public static Object[] toObjectArray(List<? extends Object> arr){Object[] ret = new Object[arr.size()];for(int i = 0; i < arr.size(); i++)ret[i] = arr.get(i);return ret;}
    
    public static String[] loadText(String fileName)throws RuntimeException
    {
        try
        {
            ArrayList<String> text = arrayList();
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) != null)
                text.add(line);
            br.close();
            return toStringArray(text);
        }
        catch(Exception e){throw new RuntimeException(e.toString());}
    }
    public static Object[] loadObjects(String fileName) throws RuntimeException
    {
		ArrayList<Object> objects = arrayList();
        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object read;
            while((read = ois.readObject()) != null)
            {
                objects.add(read);
            }
            ois.close();
            return toObjectArray(objects);
        }
		catch(EOFException exc){return toObjectArray(objects);}
        catch(Exception e){throw new RuntimeException(e.toString());}
    }
    public static void saveText(String fileName, Object[] lines)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(fileName);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            for(int i = 0; i < lines.length; i++)
            {
                bw.write(lines[i].toString());
                if(i + 1 < lines.length)//not last line
                {
                    bw.newLine();
                }
            }
            bw.close();
        }
        catch(Exception e){throw new RuntimeException(e.toString());}
    }
    public static void saveObjects(String fileName, Object[] out)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Object o : out)
                oos.writeObject(o);
            
            oos.close();
        }
        catch(Exception e){throw new RuntimeException(e.toString());}
    }
    public static Image loadImage(String s)
    {
		Image i = new ImageIcon(s).getImage();
		if(i.getHeight(null) < 0 || i.getWidth(null) < 0)
		{
			throw new RuntimeException(s + " is not a valid image path.");
		}
		return i;
    }
    public static void print(Object o){System.out.println(o);}
    public static void print(Object o, boolean newLine)
    {
        if(newLine)
            System.out.println(o);
        else
            System.out.print(o);
    }
	public static void p(Object o){System.out.println(o);}
    public static void p(Object o, boolean newLine)
    {
        if(newLine)
            System.out.println(o);
        else
            System.out.print(o);
    }
	public static void sleep(double seconds)
	{
		long milliseconds = (long)(seconds*1000);
		try
		{
			Thread.sleep(milliseconds);
		}
		catch(java.lang.InterruptedException e)
		{
			throw new RuntimeException("Don't use this sleep method if you plan to interrupt the thread!");
		}
	}
	
    public static String getInput()
    {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
    public static Iterable<Integer> range(int cap)
    {
        return range(0,cap,1);
    }
	public static Iterable<Integer> range(int start, int cap)
	{
		return range(start,cap,1);
	}
	public static Iterable<Integer> range(int start, int cap, int inc)
	{
		return ()->new Iterator<Integer>()
        {
            private int i = start;
            public boolean hasNext()
            {
                return i < cap;
            }
            public Integer next()
            {
                if(hasNext())
                {
                    int ret = i;
                    i += inc;
                    return ret;
                }
                else
                {
                    throw new RuntimeException("No more elements to iterate through");
                }
            }
        };
	}
	public static Iterable<Double> range(double start, double cap, double inc)
	{
		return ()->new Iterator<Double>()
        {
            private double i = start;
            public boolean hasNext()
            {
                return i < cap;
            }
            public Double next()
            {
                if(hasNext())
                {
                    double ret = i;
                    i += inc;
                    return ret;
                }
                else
                {
                    throw new RuntimeException("No more elements to iterate through");
                }
            }
        };
	}
    public static Iterable<Integer> range(int[] array){return range(array.length);}
    public static Iterable<Integer> range(double[] array){return range(array.length);}
    public static Iterable<Integer> range(char[] array){return range(array.length);}
    public static Iterable<Integer> range(boolean[] array){return range(array.length);}
    public static Iterable<Integer> range(long[] array){return range(array.length);}
    public static <E> Iterable<Integer> range(E[] array)
    {
        return range(array.length);
    }
    public static <E> Iterable<Integer> range(Collection<E> array)
    {
        return range(array.size());
    }
    public static <E> Iterable<Long> forever()
    {
        return ()->new Iterator<Long>()
        {
            long i = 0;
            public boolean hasNext() 
            {
                return true;
            }

            @Override
            public Long next() 
            {
                long ret = i;
                i++;
                return ret;
            }
            
        };
    }
    public static <E> Iterable<Iteration<E>> iterate(E[] e)
    {
        int cap = e.length;
        Iteration<E> iteration = new Iteration<>();
        return ()->new Iterator<Iteration<E>>()
        {
            private int i = 0;
            public boolean hasNext()
            {
                return i < cap;
            }
            public Iteration<E> next()
            {
                if(hasNext())
                {
                    iteration.e = e[i];
                    iteration.index = i;
                    iteration.reverseIndex = cap - i - 1;
                    i++;
                    return iteration;
                }
                else
                {
                    throw new RuntimeException("No more elements to iterate through");
                }
            }
        };
    }
    public static Iterable<Iteration<Integer>> iterate(int[] e)
    {
        int cap = e.length;
        Iteration<Integer> iteration = new Iteration<>();
        return ()->new Iterator<Iteration<Integer>>()
        {
            private int i = 0;
            public boolean hasNext()
            {
                return i < cap;
            }
            public Iteration<Integer> next()
            {
                if(hasNext())
                {
                    iteration.e = e[i];
                    iteration.index = i;
                    iteration.reverseIndex = cap - i - 1;
                    i++;
                    return iteration;
                }
                else
                {
                    throw new RuntimeException("No more elements to iterate through");
                }
            }
        };
    }
    public static Iterable<Iteration<Double>> iterate(double[] e)
    {
        int cap = e.length;
        Iteration<Double> iteration = new Iteration<>();
        return ()->new Iterator<Iteration<Double>>()
        {
            private int i = 0;
            public boolean hasNext()
            {
                return i < cap;
            }
            public Iteration<Double> next()
            {
                if(hasNext())
                {
                    iteration.e = e[i];
                    iteration.index = i;
                    iteration.reverseIndex = cap - i - 1;
                    i++;
                    return iteration;
                }
                else
                {
                    throw new RuntimeException("No more elements to iterate through");
                }
            }
        };
    }
    public static Iterable<Iteration<Character>> iterate(char[] e)
    {
        int cap = e.length;
        Iteration<Character> iteration = new Iteration<>();
        return ()->new Iterator<Iteration<Character>>()
        {
            private int i = 0;
            public boolean hasNext()
            {
                return i < cap;
            }
            public Iteration<Character> next()
            {
                if(hasNext())
                {
                    iteration.e = e[i];
                    iteration.index = i;
                    iteration.reverseIndex = cap - i - 1;
                    i++;
                    return iteration;
                }
                else
                {
                    throw new RuntimeException("No more elements to iterate through");
                }
            }
        };
    }
    public static Iterable<Iteration<Long>> iterate(long[] e)
    {
        int cap = e.length;
        Iteration<Long> iteration = new Iteration<>();
        return ()->new Iterator<Iteration<Long>>()
        {
            private int i = 0;
            public boolean hasNext()
            {
                return i < cap;
            }
            public Iteration<Long> next()
            {
                if(hasNext())
                {
                    iteration.e = e[i];
                    iteration.index = i;
                    iteration.reverseIndex = cap - i - 1;
                    i++;
                    return iteration;
                }
                else
                {
                    throw new RuntimeException("No more elements to iterate through");
                }
            }
        };
    }
    public static Iterable<Iteration<Boolean>> iterate(boolean[] e)
    {
        int cap = e.length;
        Iteration<Boolean> iteration = new Iteration<>();
        return ()->new Iterator<Iteration<Boolean>>()
        {
            private int i = 0;
            public boolean hasNext()
            {
                return i < cap;
            }
            public Iteration<Boolean> next()
            {
                if(hasNext())
                {
                    iteration.e = e[i];
                    iteration.index = i;
                    iteration.reverseIndex = cap - i - 1;
                    i++;
                    return iteration;
                }
                else
                {
                    throw new RuntimeException("No more elements to iterate through");
                }
            }
        };
    }
    public static <E> Iterable<Iteration<E>> iterate(ArrayList<E> e)
    {
        int cap = e.size();
        Iteration<E> iteration = new Iteration<>();
        return ()->new Iterator<Iteration<E>>()
        {
            private int i = 0;
            public boolean hasNext()
            {
                return i < cap;
            }
            public Iteration<E> next()
            {
                if(hasNext())
                {
                    iteration.e = e.get(i);
                    iteration.index = i;
                    iteration.reverseIndex = cap - i - 1;
                    i++;
                    return iteration;
                }
                else
                {
                    throw new RuntimeException("No more elements to iterate through");
                }
            }
        };
    }
    public static class Iteration<E> extends Obj
    {
        private E e;
        private int index;
        private int reverseIndex;//if you reversed the array order, what would the index be now
        public E getElement(){return e;}
        public int getIndex(){return index;}
        public int getReverseIndex(){return reverseIndex;}
    }
            
    public static <A,B> Tuple<A,B> tuple(A a, B b){return new Tuple<>(a,b);}
    public static <A,B,C> Triple<A,B,C> triple(A a, B b, C c){return new Triple<>(a,b,c);}
    public static class Tuple<A,B> extends Obj
    {
        public A a;
        public B b;
        public Tuple(A a, B b)
        {
            this.a = a;
            this.b = b;
        }
    }
    public static class Triple<A,B,C> extends Obj
    {
        public A a;
        public B b;
        public C c;
        public Triple(A a, B b, C c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static void stop()
    {
        System.exit(0); 
    }
	
	public static Clip loadSound(String soundFileName)
	{
		try 
		{
			File soundFile = new File(soundFileName);
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(soundFile));
			return clip;
		} 
		catch (Exception e) {throw new RuntimeException(e);}
	}
	public static void playSound(Clip c)
	{
		c.start();
	}
			
    
    public static String toString(Object o)
    {
        String ret = "";
        Class c = o.getClass();
        ret += "Object of " + c.getSimpleName() + "\n";
        if(o instanceof Object[])
        {
            ret += "    " + Arrays.deepToString((Object[])o);
        }
        else
        {
            for(Iteration<Field> field : iterate(c.getDeclaredFields()))
            {
                try
                {
                    field.getElement().setAccessible(true);
                    Object objectValue = field.getElement().get(o);
                    String objectString;
                    if(objectValue instanceof double[])
                        objectString = Arrays.toString((double[])objectValue);
                    else if(objectValue instanceof int[])
                        objectString = Arrays.toString((int[])objectValue);    
                    else if(objectValue instanceof char[])
                        objectString = Arrays.toString((char[])objectValue);    
                    else if(objectValue instanceof long[])
                        objectString = Arrays.toString((long[])objectValue);    
                    else if(objectValue instanceof boolean[])
                        objectString = Arrays.toString((boolean[])objectValue);    
                    else if(objectValue instanceof Object[])
                        objectString = Arrays.toString((Object[])objectValue);    
                    else
                        objectString = objectValue.toString();
                        
                    ret += "    " + field.getElement().getType().getSimpleName() + " " + field.getElement().getName() + " = " + objectString + "\n";
                }
                catch(Exception e){e.printStackTrace();}
            }
        }
        return ret;
    }
    //instance methods
    public String toString()
    {
        return toString(this);
    }
    
}
