package a.b.platformerBob;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public abstract class GameObject{
    private Vector2Point5D worldLocation;
    private float width;
    private float height;

    private   boolean active = true;
    private   boolean visible = true;
    private   int animFrameCount = 1;
    private   char type;

    private String bitmapName;


}
