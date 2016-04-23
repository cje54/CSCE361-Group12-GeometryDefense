# CSCE361-Group12-GeometryDefense

Our system starts at the GeometryDefense class.  This Activity class is the first activity of the app. 
It just contains an image for the title and buttons to play or exit the app.
Tapping the play button changes to the LevelSelect Class activity which is also fairly simple.  
Just a grid of buttons that create and switch to a LevelActivity class when pressed.

This is where the actual game is programmed.  The LevelActivity class contains the UI for the level like the buy/sell buttons
and other information and the upgrade panel.  This class also creates a LevelThread class.

The LevelThread class is just a Thread class that controls the running of the game.  It calls the update/render methods of the Level
class while it runs and tries to run at 30FPS.  So it will call update/render and then wait for the end of the frame to update/render again.

Finally the Level class which contains most of the programming.  This class has all of the information about the level's objects and states.  
It contains lists of all of its objects(Towers,Enemies,projectiles), and when its update/render methods are called by the LevelThread,
it will update/render itself and then subsequently call the update/render methods in all of its contained objects.  
This is the main flow of the game and then there is a bunch of other code to make up the details.
The level class communicates with the LevelActivity that created it to update the UI, and also receives method calls from the Activity class
when buttons are pressed.  Upon completing the level, the activity returns back to the levelselect activity and contains a levelcomplete
code which will update the levelselect and make the next level available.

The other classes are in game objects and are fairly straightforward.  Mostly just contain variables and a few methods along with updating/rending.
