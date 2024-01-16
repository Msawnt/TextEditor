import javax.swing.*;

import javax.swing.border.EmptyBorder;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.*;


public class TextEditor implements ActionListener
{

    //Declaring prop of TextEditor;
    JFrame frame;

    JMenu file, edit;


    //File menu items
    JMenuItem newFile, openFile, saveFile;


    //Edit menu items
    JMenuItem cut, copy, paste, selectAll, close;


    JTextArea textArea;

    JMenuBar menuBar;

    TextEditor ()
    {

        //Initialize a frame
        frame = new JFrame ();


        //Initialize a menuBar
        menuBar = new JMenuBar ();


        //Initialize textArea
        textArea = new JTextArea ();


        //Initialize menus
        file = new JMenu ("File");

        edit = new JMenu ("Edit");


        //Initialize file menu items
        newFile = new JMenuItem ("New Window");

        openFile = new JMenuItem ("Open File");

        saveFile = new JMenuItem (" Save File");


        //add action listener to file menu items
        newFile.addActionListener (this);

        openFile.addActionListener (this);

        saveFile.addActionListener (this);


        //adding menu items to menuBar
        file.add (newFile);

        file.add (openFile);

        file.add (saveFile);


        //Initialize edit menu items
        cut = new JMenuItem ("Cut");

        copy = new JMenuItem ("Copy");

        paste = new JMenuItem ("Paste");

        selectAll = new JMenuItem ("SelectAll");

        close = new JMenuItem ("Close");



        //Adding action listener to edit menu items
        cut.addActionListener (this);

        copy.addActionListener (this);

        paste.addActionListener (this);

        selectAll.addActionListener (this);

        close.addActionListener (this);



        //adding to edit  menu
        edit.add (cut);

        edit.add (copy);

        edit.add (paste);

        edit.add (selectAll);

        edit.add (close);



        //Adding menus to menuBar
        menuBar.add (file);

        menuBar.add (edit);

        //Set menuBar to frame
        frame.setJMenuBar (menuBar);


        //Create content pane
        JPanel panel = new JPanel ();

        panel.setBorder (new EmptyBorder (5, 5, 5, 5));


        panel.setLayout (new BorderLayout (0, 0));


        //Add text area to the panel
        panel.add (textArea, BorderLayout.CENTER);


        //Create Scroll pane
        JScrollPane scrollPane =
                new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //add scroll pane to the panel
        panel.add (scrollPane);


        //Add panel to frame
        frame.add (panel);

        // set  dimension
        frame.setBounds (0, 0, 400, 400);

        frame.setTitle ("Text Editor");

        frame.setVisible (true);

        frame.setLayout (null);

    }


    @Override
    public void actionPerformed (ActionEvent actionEvent)
    {


        if (actionEvent.getSource () == cut)
        {

            //perform cut operation
            textArea.cut ();

        }

        if (actionEvent.getSource () == copy)
        {

            // perform copy operation
            textArea.copy ();

        }

        if (actionEvent.getSource () == paste)
        {

            //perform cut operation
            textArea.paste ();

        }

        if (actionEvent.getSource () == selectAll)
        {

            //perform cut operation
            textArea.selectAll ();

        }

        if (actionEvent.getSource () == close)
        {

            //perform cut operation
            System.exit (0);

        }


        if (actionEvent.getSource () == openFile)
        {


            JFileChooser fileChooser = new JFileChooser ("D");

            int chooseOption = fileChooser.showOpenDialog (null);

            //if clicked on selected file
            if (chooseOption == JFileChooser.APPROVE_OPTION)
            {

                // getting the selected file
                File file = fileChooser.getSelectedFile ();

                //get the path of selected file
                String filePath = file.getPath ();

                try
                {

                    FileReader fileReader = new FileReader (filePath);

                    //Initialize buffer reader
                    BufferedReader bufferedReader =
                            new BufferedReader (fileReader);

                    String intermediate = "", output = "";

                    //Read contains of file line by line
                    while ((intermediate = bufferedReader.readLine ()) != null)
                    {

                        output += intermediate + "\n";

                    }

                    //Set the op string to textarea

                    textArea.setText (output);

                }
                catch (IOException fileNotFoundException)
                {

                    fileNotFoundException.printStackTrace ();

                }

            }

        }

        if (actionEvent.getSource () == saveFile)
        {


            JFileChooser filechooser = new JFileChooser ("D");


            //get choose option from file chooser
            int chooseOption = filechooser.showSaveDialog (null);

            // check if we clicked on save button
            if (chooseOption == JFileChooser.APPROVE_OPTION)
            {

                //create a new file with chosen path
                File file =
                        new File (filechooser.getSelectedFile ().getAbsolutePath () +
                                ".txt");

                try
                {

                    //Initialize file writer
                    FileWriter filewriter = new FileWriter (file);

                    //Initialize buffer  writer
                    BufferedWriter bufferedWriter =
                            new BufferedWriter (filewriter);

                    // write content of text area to file
                    textArea.write (bufferedWriter);

                    bufferedWriter.close ();

                }

                catch (IOException ioException)
                {

                    ioException.printStackTrace ();


                }

            }


        }

        //newFile function
        if (actionEvent.getSource () == newFile)
        {

            TextEditor newtexteditor = new TextEditor ();

        }



    }

    public static void main (String[]args)
    {

        TextEditor texteditor = new TextEditor ();

    }

}
