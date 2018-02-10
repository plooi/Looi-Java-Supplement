Looi-Java-Supplement

This project is called Looi-Java-Supplement, formerly called the Looi-Engine. 

There may be multiple zip files in this repositiory. I suggest that if you would like to use Looi-Java-Supplement that you use the version with the most recent date of updation.

The main goal of Looi-Java-Supplement is to make it easy for Java programmers to add a GUI interface to their program. With just one line of code, which is Window w = new Window(), one can create a functioning window that appears on the screen. With this window, one can choose to create either a standard GUI interface, using classes from the package ljs.gui, or one can create a full fledged video-game using classes from ljs.gui.looicanvas. A smaller goal of Looi-Java-Supplement is to improve productivity by providing useful utility methods such as the "range" method, the "opt" method, and the "arrayList" method, which will help programmers save time because they provide instant solutions to common problems.

To use Looi-Java-Supplement effectively, for each file one must import static ljs.Obj.* if they want to access the utility methods, and they must import ljs.gui.* if they want to access the standard gui-building classes, and they must import ljs.gui.looicanvas.* if they want to build a game. 

Here are the descriptions of the most common utility methods:

"arrayList"... <E> ArrayList<E> arrayList(E... contents)
Use the arrayList method to instantly create and populate an ArrayList of the type E that is desired. A variable amount of arguments are accepted, as this is a var-args method, and each of the arguments passed in will be the initial contents of the ArrayList that is returned. For example, making the call arrayList(1, 2, 3, 4, 5) will return an ArrayList<Integer> with the contents [1, 2, 3, 4, 5]. Making the call arrayList("a", "b", "c") will return an ArrayList<String> with the contents ["a","b","c"]
  
"linkedList"... <E> LinkedList<E> linkedList(E... contents)
Use the linkedList method to instantly create and populate a LinkedList of the type E that is desired. A variable amount of arguments are accepted, as this is a var-args method, and each of the arguments passed in will be the initial contents of the LinkedList that is returned. For example, making the call linkedList(1, 2, 3, 4, 5) will return a LinkedList<Integer> with the contents [1, 2, 3, 4, 5]. Making the call linkedList("a", "b", "c") will return a LinkedList<String> with the contents ["a","b","c"]

"loadText"... String[] loadText(String fileName)
Use this method to get the text from a file. Making a call to loadText("mydir\\dir2\\mytextdocument.txt") will return a String[] where each element in the array contains the contents, in order, of each line of the file "mydir\\dir2\\mytextdocument.txt".

"saveText"... void saveText(String fileName, Object[] lines)
Use this method to write text to the file with the name of the parameter "fileName". The parameter "lines" contains the text that is to be written to each line in the file. If any element in the array "lines" is not of the type String, the toString method will be run on that object to turn it into a String.

"loadImage"... loadImage(String imageFileName)
This method returns an Image object that represents the image that is at the file location of the parameter "imageFileName".

"print"... void print(Object o)
Usually, in Java, to print "hello world" one must write the code "System.out.println("hello world");". However, to write "System.out.println" is a lot of work. Therefore, this print method, with a much shorter name, was built to do the exact same thing. Just say "print("hello world")" and "hello world" will be printed to the screen. If the parameter is not of the type String, the toString method will be run on that object to turn it into a String, and then it will be printed.

"p"... void p(Object o)
This method does the exact same thing as the "print" method, except that the name is EVEN shorter, so you only need to type one single "p" character to call this very useful method. 

"sleep"... void sleep(double seconds)
Causes the current executing thread to pause its execution for the specified number of seconds.

"range"... Iterable<Integer> range(int start, int cap, int inc)
Returns an Iterable<Integer> that will, when passed into a for-each loop, cause the loop iterator variable to start iterating at the value of the "start" parameter, increment each time by the value of the "inc" parameter,  and stop if the loop iterator variable gets to or gets past the value of the "cap" parameter.
  
"toString"... static String toString(Object o)
Returns a String that is a meaningful description of the value of the parameter "o". This meaningful description consists of the type of the object and the values of all of its fields, including its inherited fields. 

----------------------------------------------------------------------------------------------------------------------------------------
Here is a description of the classes in ljs.gui:

