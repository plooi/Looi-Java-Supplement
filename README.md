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

"stop"... void stop()
Makes the entire program stop its execution.

----------------------------------------------------------------------------------------------------------------------------------------
Here is a description of the most important classes in ljs.gui:

"Window"... class Window
Use Window's zero argument constructor to make a new window appear on the screen. The upon closing method will cause the window to execute an action when the close (X) button on the window is pressed. Use the setBounds(int x, int y, int width, int height) method to set the window's location and dimensions. Use the Window's add(Component c) method to add a GUI component to the window.

"Component"... abstract class Component
This class is the superclass of all GUI components that can be added to a window. It has methods like setBounds(int x, int y, int width, int height), which will set the component's location and dimensions, and setVisible(boolean b) which will make the component visible or not. All components will initially be located at 0,0 with width and height of 200,200, util the setBounds method is called.

"Button"... class Button extends Component
Instantiate a Button using the constructor that takes a single argument of an Action, and that Action will be performed upon the pressing of the Button. This class inherits all abilities of the Component class. Do not forget that a Button must added to a window before it will show up in the window.

"TextBox"... class TextBox extends Component
Instantiate a TextBox using the no argument constructor, and you will automatically have a text box that the user can type text into. Use the getText() method to access that text. This class inherits all abilities of the Component class. Do not forget that a TextBox must added to a window before it will show up in the window.

"Picture"... class Picture extends Component
Instantiate a Picture by passing in either an Image or Color into the constructor. When added to a window, a Picture object will display a the corresponding image (or just a big rectange of the corresponding color if the color constructor was used) at its x,y,with,height which are properties of the superclass. This class inherits all abilities of the Component class. Do not forget that a Picture must added to a window before it will show up in the window.

Here is some code that makes a Window, a TextBox, and a Button, and whenever the Button is pressed, the program prints out the text that is in the TextBox.

import ljs.gui.*;
import static ljs.Obj.*;

public class Main
{
    public static void main(String[] args)
    {
        Window w = new Window();
        w.uponClosing(()->stop());
        
        TextBox tb = new TextBox();
        tb.setBounds(250,0,150,40);
        
        Button b = new Button(()->print(tb.getText()));
        b.setBounds(250,40,150,40);
        b.setLabel("Print it!");
    
        w.add(tb);
        w.add(b);
    }
}

----------------------------------------------------------------------------------------------------------------------------------------
Here is a description of the most important classes in ljs.gui.looicanvas:

"LooiCanvas"... class LooiCanvas extends Component
A LooiCanvas is a canvas on which a complicated gui display, such as a videogame, can be drawn on. There are many constructors, but you may use the zero arg constructor as it is the least complicated. Do not forget that a LooiCanvas must added to a window before it will show up in the window. Before it will work properly, however, you MUST call the (Object of LooiCanvas).start() method. Then, it will start rendering the game display.

"LooiObject"... class LooiObject
A LooiObject is an object that when made, it will be by default added to the LooiCanvas' collection of active LooiObjects. Whoa, what is an active LooiObject? An active LooiObject is a LooiObject that will have its looiStep() and looiPaint() methods called approximately once per rendering cycle. Override the looiStep() and looiPaint() methods to achieve the functionality that you want. looiStep() should be overridden with the calculations, or other such things that should run at every "step" in the game. looiPaint() should be overridden to perform the graphical painting operations that will be performed at every step, such as fillRect(double x, double y, double width, double height) and setColor(Color color), to name a few. All the graphical painting operations are instance methods of LooiObject.

Here is some sample code that creates a Window, LooiCanvas, and a LooiObject, and that LooiObject is responsible for making a square rotate around the center of the screen:

import ljs.gui.*;
import ljs.gui.looicanvas.*;
import static ljs.Obj.*;

public class Main
{
    public static void main(String[] args)
    {
        Window w = new Window();
        w.uponClosing(()->stop());
        
        LooiCanvas lc = new LooiCanvas();
        w.add(lc);
        lc.fullScreen();
        
        new LooiObject()
        {
            double timer = 0;
            public void looiStep()
            {
                timer += .03;
            }
            public void looiPaint()
            {
            
                fillRect(800+300*Math.cos(timer),500 + 300*Math.sin(timer),50,50);
            }
        };
        
        lc.start();
    
    }
}
