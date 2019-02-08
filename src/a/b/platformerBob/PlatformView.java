package a.b.platformerBob;

import   android.content.Context;
import   android.graphics.Canvas;
import   android.graphics.Color;
import   android.graphics.Paint;
import   android.graphics.Rect;
import   android.util.Log;
import   android.view.SurfaceHolder;
import   android.view.SurfaceView;

public class PlatformView extends SurfaceView
    implements Runnable {

    private boolean debugging = true;
    private volatile boolean running;
    private Thread gameThread = null;

    // For drawing
    private Paint paint;
    // Canvas could initially be local.
    // But later we will use it outside of draw()
    private Canvas canvas;
    private SurfaceHolder ourHolder;

    Context context;
    long startFrameTime;
    long timeThisFrame;
    long fps;

    // Our new engine classes
    private LevelManager lm;
    private Viewport vp;
    InputController ic;

    PlatformView(Context context, int screenWidth,
		 int screenHeight) {

	super(context);
	this.context = context;

	// Initialize our drawing objects
	ourHolder = getHolder();
	paint = new Paint();
    }

    @Override
    public void run() {

	while (running) {



	    startFrameTime = System.currentTimeMillis();

	    update();
	    draw();

	    // Calculate the fps this frame
	    // We can then use the result to
	    // time animations and movement.
	    timeThisFrame = System.currentTimeMillis() - startFrameTime;
	    if (timeThisFrame >= 1) {
		fps = 1000 / timeThisFrame;
	    }
	}
    }

    private void update() {
	// Our new update() code will go here
    }


    private void draw() {

            if (ourHolder.getSurface().isValid()){
             //First we lock the area of memory we will be drawing to
             canvas = ourHolder.lockCanvas();

             // Rub out the last frame with arbitrary color
             paint.setColor(Color.argb(255, 0, 0, 255));
             canvas.drawColor(Color.argb(255, 0, 0, 255));

             // New drawing code will go here

             // Unlock and draw the scene
             ourHolder.unlockCanvasAndPost(canvas);
        }
    }


   // Clean up our thread if the game is interrupted
   public void pause() {
     running = false;
      try {
          gameThread.join();
      } catch (InterruptedException e) {
          Log.e("error", "failed to pause thread");
      }
   }

   // Make a new thread and start it
   // Execution moves to our run method
   public void resume() {
      running = true;
      gameThread = new Thread(this);
      gameThread.start();

   }

}// End of PlatformView


