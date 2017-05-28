/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 * @author Daljit Bhalla
 */
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class alert extends MIDlet implements CommandListener
{
private Display display;
private Form form;
private Command exit;
private Command process;
private ChoiceGroup gender;
private int currentIndex;
private int genderIndex;
private TextField textfield;
private Alert alert1;
public alert()
{
display = Display.getDisplay(this);
gender = new ChoiceGroup("Enter Gender", Choice.EXCLUSIVE);
gender.append("Female", null);
currentIndex = gender.append("Male ", null);
gender.setSelectedIndex(currentIndex, true);
exit = new Command("Exit", Command.EXIT, 1);
process = new Command("Process", Command.SCREEN,2);
textfield = new TextField("Email", "", 30, TextField.EMAILADDR);
form = new Form("Gender");
form.append(textfield);
genderIndex = form.append(gender);
form.addCommand(exit);
form.addCommand(process);
form.setCommandListener(this);
}
public void startApp()
{
display.setCurrent(form);
}
public void pauseApp()
{
}
public void destroyApp(boolean unconditional)
{
}

public void commandAction(Command command, Displayable displayable)
{
if (command == exit)
{
destroyApp(false);
notifyDestroyed();
}
else if (command == process)
{
currentIndex = gender.getSelectedIndex();
String message="Gender: ";
message=message+gender.getString(currentIndex)+"\n";
message=message+"Email: "+textfield.getString();
alert1 = new Alert("Busy", message,null, AlertType.WARNING);
alert1.setTimeout(Alert.FOREVER);
display.setCurrent(alert1, form);
form.delete(genderIndex);
form.removeCommand(process);
}
}
}

alert.txt
Displaying alert.txt.
