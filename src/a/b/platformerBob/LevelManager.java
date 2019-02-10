package a.b.platformerBob;

import   android.content.Context;
import   android.graphics.Bitmap;
import   android.graphics.Rect;
import   java.util.ArrayList;



public class LevelManager{
    private String level;
    int mapWidth;
    int mapHeight;

    Player player;
    int playerIndex;

    private boolean playing;
    float gravity;

    LevelData levelData;
    ArrayList<GameObject> gameObjects;

    ArrayList<Rect> currentButtons;
    Bitmap[] bitmapsArray;

    public LevelManager(Context context,
			int pixelsPerMetre, int screenWidth,
			InputController ic,
			String level,
			float px, float py) {

        this.level = level;

        switch (level) {
	case "LevelCave":
            levelData = new LevelCave();
            break;

	    // We can add extra levels here

	}

	// To hold all our GameObjects
	gameObjects = new ArrayList<>();

	// To hold 1 of every Bitmap
	bitmapsArray = new Bitmap[25];

	// Load all the GameObjects and Bitmaps
	loadMapData(context, pixelsPerMetre, px, py);

	// Ready to play
	playing = true;
    }



    public boolean isPlaying() {
        return playing;
    }


}
