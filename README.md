# CSCI 1302 - Artsy Project (cs1302-artsy)

This repository contains the skeleton code for the Art project assigned
to the students in the Fall 2015 CSCI 1302 classes at the 
University of Georgia. 

**Please read the entirety of this file before beginning your project.**

## Due Date

This project is due on Friday 2015-10-23 @ 11:55 PM.

## Academic Honesty

You implicitly agree to Academic Honesty policy as outlined in the course 
syllabus and course website.

In accordance with the notice above, I must caution you **not** to fork this
repository on GitHub if you have an account. Doing so will more than likely make
your copy of the project publicly visible. Please follow the instructions 
contained in the Resources section below in order to do your development on
<code>nike</code>.

## Project Description

![Artsy](http://i.imgur.com/YciJ2sl.png)

Your goal is to implement a Java application that can stitch together multiple images in
a number of "artsy" ways. This project will make use of interfaces and Java Swing.
This will require you to lookup things in Javadoc and apply your knowledge of
things like inheritance, polymorphism, anonymous classes and lambda expressions.

Part of software development is being given a goal but not necessarily being 
given instruction on all of the details needed to accomplish that goal. For example,
even though image manipulation hasn't been covered in class, in order to complete this 
project you are going to need to lookup how to load, interact with, and save images in Java.
Also, since this is your first project with Swing, you will probably need to consult the 
Oracle tutorials and definitely the Java SE 8 JavaDoc for assistance. 

This project is also designed to help you better understand how object communicate
with each other. Since GUI containers can be nested, you need to make sure that
your components and listeners have communication access to objects the need in
order to function correctly. While you can technically write your entire Swing-based
GUI application entirely in the <code>createAndShowGUI</code> method, this will
make your code messy, hard to read, and result in lots of duplicate code.
Before you write any code, you should plan out your containment heirarchy and
design classes involving inheritance and polymorphism appropriately. Then, wehen
you go to write the code for your GUI, use the classes you designed, changing
them as needed.

## Project Tasks

Before you submit your project, you need to perform the following tasks:

#### (40 points) Implement the <code>cs1302.effects.Artsy</code> interface in the <code>cs1302.p2.MyArtsy</code> class.

Information about the implementation details can be found in the JavaDoc comments 
for the interface as well as inferred from the images contained elsewhere in this 
document.
 
   * (20 points) The <code>doRotate</code> method is implemented correctly.
   * (10 points) The <code>doCheckers</code> method is implemented correctly.
   * (5 points) The <code>doHorizontalStripes</code> method is implemented correctly.
   * (5 points) The <code>doVerticalStripes</code> method is implemented correctly.

__Note:__ The actual grading rubric will involve testing each of the items 
above in discrete parts so that partial credit can be earned.

#### (60 points) Implement a graphical user interface in Swing.

Your GUI should resemble and function like the one described in the 
"User Interface" section of this document. 

   * (20 points) The menu bar works as described in this document.
   * (20 points) The tool bar works as described in this document.
   * (20 points) The image panels work as described in this document. 

__Note:__ The entry point to your program must be in <code>cs1302.p2.Driver</code> class. 
All that means is that the <code>cs1302.p2.Driver</code> class is used to run 
your program. However, some code has been written in that class to help make your 
code more thread-safe. Instead of creating and displaying your GUI in the 
<code>main</code> method, you should do it in the <code>createAndShowGUI</code>
method. There is already some code there to get you started.

__Note:__ Your program should create a single instance of your <code>MyArtsy</code> class.
You should pass around this object as an <code>Artsy</code> object (relying on 
subsumption and polymorphism) so that your code can potentially use another
developer's <code>Artsy</code> implementation. This is noted in the 
<code>createAndShowGUI</code> method in the <code>Driver</code> class.

__Note:__ Your program should not crash. Exceptions and errors should be
handled so that the user experience is not hindered. If an error or
exception cannot be handled, a user should first be notified of error,
then the program should exit.  

__Note:__ The actual grading rubric will involve testing each of the items
above in discrete parts so that partial credit can be earned.
   
#### Update the <code>README.md</code> file.

Update the <code>README.md</code> in your project directory (this file) to 
contain the following information at the top of the file (updating it with 
your own information:

```markdown
# Project Submission

Author: YOUR NAME (LAST 3 DIGITS OF 810 NUMBER HERE)

[If you did any of the extra credit then please indicate that here.]
```
        
## Extra Credit Project Tasks

You may earn extra credit for each of the tasks listed below:

 1. (10 points extra credit) Konami Code: Make it so that when the user enters 
 <code>↑</code><code>↑</code><code>↓</code><code>↓</code><code>←</code><code>→</code><code>←</code><code>→</code><code>B</code><code>A</code> on the keyboard (with the application in focus), a dialog box appears 
 with a picture of [Grumpy Cat](http://knowyourmeme.com/memes/grumpy-cat). I 
 recommend that you keep your picture of Grumpy Cat in the <code>resources</code> 
 directory.

   __Note:__ In order to receive credit for Extra Credit 1, the grader must be
   able to enter the Konami Code *whenever* a dialog box is not present on the
   screen. It should also be possible to enter the code multiple times while
   the program is being run.

 2. (10 points extra credit) Modify your program so that a user can open files
 from both the local file system and via a URL. When a user chooses to open a 
 file using the File -> Open -> ... menu, he or she is presented an option
 that is functionally similar to the following images:

 ![Local File](http://i.imgur.com/1X06iXA.png)
 ![Remote File](http://i.imgur.com/husPD22.png)

   __Note:__ In order to receive credit for Extra Credit 2, both the visual aspect
   and functional aspect of opening local and remote files needs to be implemented. 

## Working with Images

The are two main classes that you must learn about to work with images:

 * The <code>java.awt.Image</code> class is the superclass that represents
   graphical images as rectangular arrays of pixels.
 * The <code>java.awt.image.BufferedImage</code> class, which extends the
   <code>Image</code> class to allow the application to operate directly
   with image data (for example, retrieving or setting up the pixel color).
   Applications can directly construct instances of this class.

You should familiarize yourself with the <code>BufferedImage</code> class
mentioned above by reading its API documention
[here](http://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html).

To create a new blank <code>BufferedImage</code> object, you can do
something like the following:

```java
int width  = 300;
int height = 300;
BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
```

To create a <code>BufferedImage</code> from a file, you can use the
static methods in the
[<code>javax.imageio.ImageIO</code>](https://docs.oracle.com/javase/8/docs/api/javax/imageio/ImageIO.html)
class. For example, you might do something like the following:

```java
File imageFile   = new File("pic.png");
BufferedImage bi = null;
try {
    bi = ImageIO.read(imageFile);
} catch (IOException e) {
    // inform user that there was an io error
} // try

if (bi != null) {
 // do stuff
 // ...
} // if
```

To save a <code>BufferedImage</code> object to a file, you can also use the
static methods in the <code>ImageIO</code> class. For example, you might
do something like this:

```java
// BufferedImage bi is declared somewhere else
File imageFile = new File("saved.png");
try {
    ImageIO.write(bi, "png", imageFile);
} catch (IOException e) {
    // inform user that there was an io error
} // try
```

In the code snippet above we defaulted to using the PNG image format. This
involved two things: i) telling the <code>write</code> method that the
format was <code>"png"</code>; and ii) making sure that the file has a
<code>.png</code> filename extension. To see a list of the formats
supported by the JVM, you can do something like the following:

```java
String[] formats = ImageIO.getWriterFormatNames();
System.out.println(Arrays.toString(formats));
```

Additionally, you may find the methods and constants availible in the
<code>java.awt.Color</code> class useful for working with colors.

## Artsy Interface

Here is some detailed information about what the graders expect to see
from your user interface. While your final design does not need to match
the following set of pictures exactly, you need to provide (at a minimum)
the same functionality. Here is what the program should resemble when it
first launches:

![Artsy](http://i.imgur.com/YciJ2sl.png)

There is a menu bar with a File menu. Underneath the menu bar there are
some buttons for performing the various artsy effects. There are also
placeholders for three different images. Above the first two images,
the file names of the images are present. Underneath each image there
are two buttons that perform various effects on that image.

The placeholder image is located in the <code>resources</code> directory
provided in the root of this project.

Here a closer look at the File menu:

![File Menu](http://i.imgur.com/7V90nli.png)

When the user chooses to open an image, a <code>JFileChooser</code> should open
up, allowing the user to browse for an image file, open it, and have that image
display in the appropriate place. When the user chooses to save the result, a
<code>JFileChooser</code> should open up, allowing the user to browse for a
location to save the result image. The actual image file should be written to
the file location specified by the user. Also, when the user choose to exit, the
entire application should immediately exit.

__Note:__ There is a great tutorial on file chooser at
[this](http://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html) link. 

__Note:__ To make things easier, save the Result image in one of the formats
listed in the array returned by <code>ImageIO.getWriterFormatNames()</code>.

After opening Image 1 and Image 2, the program should look something like this
(these sample images are located in the <code>samples</code> directory in the
root of this project):

![Loaded](http://i.imgur.com/JOdTmw8.jpg) 

Here is a before and after shot of clicking on the "rotate" button for Image 1:

![Before Rotate](http://i.imgur.com/ds34jlc.jpg)

As you can see, the user if prompted to enter the angle, in degrees, that the
image should be rotated. If the user cancels then no rotation should be
performed. If the user enters in an invalid input (in this case, not a number),
then a dialog box should appear letting the user know that the input was invalid
and the user should be re-prompted.

![After Rotation](http://i.imgur.com/ozslJvg.jpg)

As you can see, after a valid degree value is provided, Image 1 is rotated.
This effect should be achieved by using your <code>MyArtsy</code> class.

If, at any time, the user clicks on the "reset" button for a particular image,
that image should be reset to what it was before any modifications were made.
For the first two images, this will return them to their original state. For
the result image, this should revert the image back to the default image.

When saving, do not save changes to Image 1 and Image 2 back to their
respective files. The only image that will be saved is the Result image,
if the user chooses to do so.

Here is a before and after shot of the Artsy checkers effect:

![Before Checkers](http://i.imgur.com/sZCsHfJ.jpg)

Just like before, the user is prompted to enter a value. If the user cancels,
no effect should be applied. If the user enters in an invalid input (in this
case, not an integer), then a dialog box should appear letting the user know
that the input was invalid and the user should be re-prompted.

![After Checkers](http://i.imgur.com/CVPrsJ2.jpg)

As you can see, after a valid input is provided, the two images were combined
using the Artsy checkers effect and the result was displayed in the Result
image. This effect should be achieved by using your <code>MyArtsy</code> class.

Here are images for the horizontal stripes and vertical stripes effects:

![Before Vertical Stripes](http://i.imgur.com/OkVQ4xx.jpg)

![After Vertical Stripes](http://i.imgur.com/6OTYDdu.jpg)

![Before Horizontal Stripes](http://i.imgur.com/lbkyCDO.jpg)

![After Horizontal Stripes](http://i.imgur.com/WRAqVDv.jpg)

If a user rotates an image, the rotated version of the image should be used to
produce the Result image when an Artsy effect is applied. Here is an example:

![Rotated and Artsy](http://i.imgur.com/3OIXVY3.jpg)

That pretty much sums it up. If you have any questions, feel free to consult the
instructor or the TAs via Piazza. 

## Suggestions

I would suggest breaking up your interface into multiple classes as needed in 
order to reduce repetition and increase code reuse.
For example, you know that there are three images, each with their own "rotate" 
and "reset" buttons.
Think about creating a separate class that extends <code>JPanel</code>, containing
GUI components to display an image, its label, as well as those two buttons. This
class can also contain convenience methods for opening/saving a file, displaying 
the image for that panel. You can also include the action listeners for that 
panel's buttons as inner classes (named or anonymous). That way, you only write 
the code once (instead of three times) and you simply create three different objects
of that panel class to add to your GUI.

## Resources

The files for this project are hosted Github using <code>git</code>. They can be
retrieved by cloning the repository found at <code>git://github.com/mepcotterell-cs1302/cs1302-artsy.git</code>. 
For example, you can issue the following command to clone the repository:

    $ git clone git://github.com/mepcotterell-cs1302/cs1302-artsy.git LastName-FirstName-p2

As always, I suggest developing directly on <code>nike.cs.uga.edu</code> because
this is where your project will be run and tested. Since <code>git</code> is 
already installed on <code>nike</code>, you can clone the project directly into 
your <code>nike</code> home directory using the command provided above.

If any changes are made to the project description or skeleton code, they will
be announced in class. In order to incorporate such changes into your code, you 
need only do a <code>git pull</code>.

Also, since <code>git</code> is a decentralized version control system, you will
have your own local copy of the repository. This means that you can log your 
changes using commits and even revert to a previous revision if necessary.

## Directory Structure and Packages

The <code>Artsy</code> interface is contained in the <code>cs1302.artsy</code> 
package under the <code>src/main/java/cs1302/artsy</code> directory. The other 
classes of interest for this project should be contained in the 
<code>src/main/java/cs1302/p2</code> directory. 
These classes are in the <code>cs1302.p2</code> package.

## Build System

For this project, we will be using the [Simple Build System (sbt)](http://www.scala-sbt.org/). 
If you clone the project from the GitHub repository then everything you need 
in order to compile and run your project on <code>nike</code> is already included. 
In order to compile your project, you can use the following command:

    $ ./sbt compile

To run your project, use the following command:

    $ ./sbt run

In order to clean your project (remove compiled code), use the following command:

    $ ./sbt clean

## Submission Instructions

You will still be submitting your project via <code>nike</code>. Make sure your 
work is on <code>nike.cs.uga.edu</code> in a directory called 
<code>LastName-FirstName-p1</code>, and, from within the parent directory, 
execute the following command, depending on which section you are in:

### Supa' Mike's (Cotterell's) Section

    $ submit LastName-FirstName-p2 cs1302a

### Alothman's Section

    $ submit LastName-FirstName-p2 cs1302b

It is also a good idea to email a copy to yourself. To do this, simply execute 
the following command, replacing the email address with your email address:

    $ tar zcvf LastName-FirstName-p2.tar.gz LastName-FirstName-p2
    $ mutt -s "[cs1302] p2" -a LastName-FirstName-p2.tar.gz -- your@email.com < /dev/null

## Questions

If you have any questions, please post them on Piazza.

## Frequently Asked Questions

 1. What do I do if the <code>sbt</code> command does not execute?

    You probably need to make the file executable. To do this, simply make sure 
    you are in the same directory as <code>sbt</code> and issue the following
    command:

        $ chmod +x sbt

    This command updates the permissions on the file, making it executable for the
    current user.
    

 2. I created a <code>Driver</code> class (a class with a <code>main</code> method), 
    but <code>sbt</code> won't run it when I execute <code>sbt run</code>. How do I
    fix that?

    You should be able to fix the problem by executing the following command:

        $ sbt clean

 3. When I execute the <code>sbt run</code> command on <code>nike</code>, I get 
    a <code>java.awt.HeadlessException</code> that tells me no X11 DISPLAY 
    variable was set, but this program performed an operation which requires it.
    What is going on and how do I fix it?

    This exception is thrown if you are not running an X server on your computer
    or you are not telling your SSH client how to connect to the X server on
    your computer.

    If you are connecting to <code>nike</code> using a Linux or MacOS X machine
    then you probably already have an X server installed. If that is the case
    then you need to login using the following command:

        $ ssh -X username@nike.cs.uga.edu

    If you are using MacOS X and are unable to resolve your problem simply by
    issuing the above command then follow the directions [here](http://tutorialgenius.blogspot.com/2012/03/how-to-enable-x11-forwarding-with-ssh.html).
    After following the steps on that website, try logging into nike using the 
    SSH command above.

    If you are connecting to <code>nike</code> using PuTTY on Windows then you 
    need to download and install Xming. For information about how to setup Xming
    with Putty, please follow the directions [here](http://blog.nth-design.com/2010/05/19/x11-putty-xming/).
    You may skip some of the steps on that website (e.g., the section on 
    downloading and installing PuTTY), however, please read all of the sections
    related to Xming as wells the sections related to configuring PuTTY.\

 4. None of these questions are even close to the question I have. What should I
    do?

    You should post such questions to Piazza.



