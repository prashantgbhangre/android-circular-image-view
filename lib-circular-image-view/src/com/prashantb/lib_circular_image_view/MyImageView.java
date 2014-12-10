package com.prashantb.lib_circular_image_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MyImageView extends ImageView {

	private int stroke;
	private int strokeColor;

	public MyImageView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MyImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(attrs, context);
	}

	public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		init(attrs, context);
	}

	private void init(AttributeSet attrs, Context context) {
		// TODO Auto-generated method stub
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.MyImageView);
		final int N = a.getIndexCount();
		for (int i = 0; i < N; i++) {
			int attr = a.getIndex(i);
			switch (attr) {
			case R.styleable.MyImageView_stroke:
				stroke = a.getInt(attr, 0);
				break;

			case R.styleable.MyImageView_strokeColor:
				strokeColor = a.getColor(attr, Color.TRANSPARENT);
				break;
			}
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		BitmapDrawable drawable = (BitmapDrawable) getDrawable();

		if (drawable == null) {
			return;
		}

		if (getWidth() == 0 || getHeight() == 0) {
			return;
		}

		Bitmap fullSizeBitmap = drawable.getBitmap();

		int scaledWidth = getMeasuredWidth();
		int scaledHeight = getMeasuredHeight();

		Bitmap mScaledBitmap;
		if (scaledWidth == fullSizeBitmap.getWidth()
				&& scaledHeight == fullSizeBitmap.getHeight()) {
			mScaledBitmap = fullSizeBitmap;
		} else {
			mScaledBitmap = Bitmap.createScaledBitmap(fullSizeBitmap,
					scaledWidth, scaledHeight, true /* filter */);
		}

		Bitmap circleBitmap = getCircledBitmap(mScaledBitmap);
		canvas.drawBitmap(circleBitmap, 0, 0, null);

	}

	Bitmap getCircledBitmap(Bitmap bitmap) {

		Bitmap result = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Bitmap.Config.ARGB_8888);

		Canvas canvas = new Canvas(result);

		Paint paint = new Paint();

		Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
				bitmap.getWidth() / 2 - (stroke*2), paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		

			if (stroke > 0 ) {
				Paint paint1 = new Paint();
				paint1.setColor(strokeColor);
				paint1.setStrokeWidth(stroke);
				paint1.setStyle(Paint.Style.STROKE);
				paint1.setAntiAlias(true);
				canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
						(bitmap.getWidth() / 2) - (stroke*2), paint1);
			}
			

		return result;
	}

	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
	}

	public int getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(int strokeColor) {
		this.strokeColor = strokeColor;
	}
}
