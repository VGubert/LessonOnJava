package com.example.p1471_region;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint p;
        Rect rect1;
        Rect rect2;
        Region region;
        RegionIterator iterator;
        Path path;

        Region.Op op = Region.Op.XOR;


        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);

            // прямоугольники
            rect1 = new Rect(200,200,400,400);
            rect2 = new Rect(300,300,500,500);

            // создание региона
            region = new Region();
            region.set(rect1);
            region.op(rect2, op);

            // создание path из региона
            path = region.getBoundaryPath();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // контуры прямоугольников
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.BLACK);
            canvas.drawRect(rect1, p);
            canvas.drawRect(rect2, p);

            // path
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.BLUE);
            canvas.drawPath(path, p);

        }
    }
}