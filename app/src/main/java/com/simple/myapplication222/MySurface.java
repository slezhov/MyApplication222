package com.simple.myapplication222;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class MySurface extends SurfaceView implements SurfaceHolder.Callback{
    private float x = 100;
    private boolean work = true;

    public MySurface(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        /*Canvas canvas = holder.lockCanvas();
        canvas.drawColor(Color.YELLOW);
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        canvas.drawCircle(x, 100, 40,p);
        holder.unlockCanvasAndPost(canvas);*/
        new MyThread().start();
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        x = event.getX();
        return false;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        work = false;
    }
    class MyThread extends Thread{


        @Override
        public void run() {
            while (work){
                Canvas canvas = getHolder().lockCanvas();
                canvas.drawColor(Color.YELLOW);
                Paint p = new Paint();
                p.setColor(Color.BLUE);
                canvas.drawCircle(x, 100, 40,p);
                getHolder().unlockCanvasAndPost(canvas);
                x += 10;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
