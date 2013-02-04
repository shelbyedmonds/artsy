# CSCI 1302 - Art Project (cs1302-artsy)

This repository contains the skeleton code for the Art project assigned
to the students in Michael E. Cotterell's Spring 2013 CSCI 1302 class at the 
University of Georgia. 

**Please read the entirety of this file before beginning your project.**

## Academic Honesty

You implicitly agree to Academic Honesty policy as outlined in the course 
syllabus and course website (available at: http://cs.uga.edu/~mec/cs1302/).

In accordance with the notice above, I must caution you **not** to fork this
repository on GitHub if you have an account. Doing so will more than likely make
your copy of the project publicly visible. Please follow the instructions 
contained in the Resources section below in order to do your development on
<code>nike</code>.

## Project Description

Your goal is to implem

## Project Tasks

Before you submit your project, you need to perform the following tasks:

 1. blah blah
   
 2. Update the <code>README.md</code> in your project directory (this file) to 
    contain the following information at the top of the file (updating it with 
    your own information:

    ```markdown
    # Project Submission

 Author: YOUR NAME (LAST 3 DIGITS OF 810 NUMBER HERE)

    [If you did any of the extra credit then please indicate that here.]
    ```
        
## Extra Credit Project Tasks

You may earn extra credit for each of the tasks listed below:

 1. (10 points extra credit) 

## Art Project

test

## Resources

The files for this project are hosted Github using <code>git</code>. They can be
retrieved by cloning the repository found at <code>git://github.com/mepcotterell-cs1302/cs1302-life.git</code>. 
For example, you can issue the following command to clone the repository:

    $ git clone git://github.com/mepcotterell-cs1302/cs1302-life.git LastName-FirstName-p1

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

All of the non-test classes for this project should be contained in the 
<code>src/main/java/</code> directory. These classes are in the default package.

## Build System

For this project, we will be using the [Simple Build System (sbt)](http://www.scala-sbt.org/). 
If you clone the project from the GitHub repository then everything you need 
in order to compile and run your project on <code>nike</code> is already included. 
In order to compile your project, you can use the following command:

    $ ./sbt compile

To run your project, use the following command:

    $ ./sbt "run Driver seeds/seedFile"

In order to clean your project (remove compiled code), use the following command:

    $ ./sbt clean

## Submission Instructions

You will still be submitting your project via <code>nike</code>. Make sure your 
work is on <code>nike.cs.uga.edu</code> in a directory called 
<code>LastName-FirstName-p1</code>, and, from within the parent directory, 
execute the following command:

    $ submit LastName_FirstName-p2 cs1302b

It is also a good idea to email a copy to yourself. To do this, simply execute 
the following command, replacing the email address with your email address:

    $ tar zcvf LastName-FirstName-p2.tar.gz LastName-FirstName-p2
    $ mutt -s "[cs1302] p2" -a LastName-FirstName-p2.tar.gz -- your@email.com < /dev/null

## Questions

If you have any questions, please email them to Michael E. Cotterell at 
<code>mepcotterell+1302@gmail.com</code>

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

 3. None of these questions are even close to the question I have. What should I
    do?

    You should email your question to Michael E. Cotterell at 
    <code>mepcotterell+1302@gmail.com</code>

