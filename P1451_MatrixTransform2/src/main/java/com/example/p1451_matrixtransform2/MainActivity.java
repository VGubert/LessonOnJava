package com.example.p1451_matrixtransform2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
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
        Paint pBlack;
        Paint pGray;
        Path path;
        Path pathDst;
        RectF rectf;
        Matrix matrix;
        float[] src;
        float[] dst;
        float[] dst2;
        int points = 3;


        public DrawView(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);

            pGray = new Paint();
            pGray.setColor(Color.GRAY);
            pGray.setStrokeWidth(3);

            pBlack = new Paint();
            pBlack.setColor(Color.BLACK);
            pBlack.setStrokeWidth(3);

            path = new Path();
            pathDst = new Path();
            matrix = new Matrix();

            rectf = new RectF(100,100,200,200);
            src = new float[]{100,100,200,200,200,100};
            dst = new float[]{50,300,250,500,230,350};
            dst2 = new float[]{400,200,500,200,440,100};
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);

            // зеленый квадрат
            path.reset();
            path.addRect(rectf, Path.Direction.CW);
            p.setColor(Color.GREEN);
            canvas.drawPath(path, p);
            canvas.drawLine(src[0], src[1], src[2], src[3], pBlack);
            canvas.drawLine(src[0], src[1], src[4], src[5], pGray);

            // синий квадрат
            // преобразование
            matrix.setPolyToPoly(src, 0, dst, 0, points);
            path.transform(matrix, pathDst);
            // рисование
            p.setColor(Color.BLUE);
            canvas.drawPath(pathDst, p);
            canvas.drawLine(dst[0], dst[1], dst[2], dst[3], pBlack);
            canvas.drawLine(dst[0], dst[1], dst[4], dst[5], pGray);

            // красный квадрат
            // преобразование
            matrix.setPolyToPoly(src, 0, dst2, 0, points);
            path.transform(matrix, pathDst);
            // рисование
            p.setColor(Color.RED);
            canvas.drawPath(pathDst, p);
            canvas.drawLine(dst2[0], dst2[1], dst2[2], dst2[3], pBlack);
            canvas.drawLine(dst2[0], dst2[1], dst2[4], dst2[5], pGray);
        }
    }

}