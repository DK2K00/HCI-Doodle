package com.example.doodler;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MyCanvas extends View {
    Paint paint;
    Path path;


    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        path = new Path();
       // paint.setAntialias(true);
        paint.setColor(Color.RED);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
    }

    @Override

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float xPos = event.getX();
        float yPos = event.getY();

        switch(event.getAction()){
            case MotionEvent
                    .ACTION_DOWN:
                path.moveTo(xPos,yPos);
                paint.setColor(Color.BLUE);
                return true;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(xPos,yPos);
                paint.setColor(Color.BLACK);
                break;

            case MotionEvent.ACTION_UP:
                path.moveTo(xPos,yPos);
                paint.setColor(Color.RED);
                break;

            default:
                return false;
        }
        invalidate();
        return true;
    }
}
