package com.g2m.dtoast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;

import static android.view.View.inflate;
import static java.security.AccessController.getContext;

public class DStyleToast  {
    private String text;
    private Bulider bulider;
    private Context context;
    TextView textView;
    LinearLayout rootLayout;
    private float cornerRadius = -1;
    private int backgroundColor;
    private int strokeColor;
    private int strokeWidth;
    private int style;
    private int iconStart;
    private int iconEnd;
    private int textColor;
    private int font;
    private int length;
    private float textSize;
    private boolean solidBackground;
    private boolean textBold;
TypedArray typedArray;


    public DStyleToast(Bulider bulider){
        Log.v("qqqq",bulider.text);
        context=bulider.context;
        this.strokeColor=bulider.strokeColor;
        this.strokeWidth=bulider.strokeWidth;
        this.backgroundColor=bulider.backgroundColor;
        this.cornerRadius=bulider.cornerRadius;



    }
    public DStyleToast(){
        bulider=new Bulider();

    }

    public DStyleToast(Context ctx, String ssss, int style) {
        this.context=ctx;
        text=ssss;
        this.style=style;
    }

    public static DStyleToast makeToast(Context ctx, String ssss, @StyleRes int style) {
        return new DStyleToast(ctx,ssss,style);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void show(){
        getView();
       Toast toast = new Toast(context);
        toast.setDuration( Toast.LENGTH_LONG);
        toast.setView(rootLayout);
        toast.show();
    }

    private void putIcon() {
        Drawable drawable=context.getResources().
                getDrawable(R.drawable.ic_announcement_black_24dp);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("ResourceAsColor")
    private void getView() {

        View v = inflate(context, R.layout.toast_layout, null);
        rootLayout = v.findViewById(R.id.parent);
         textView=v.findViewById(R.id.toast_text);

        typedArray = context.obtainStyledAttributes(R.style.mytoast, R.styleable.DStyleToast);
        //rootLayout.setBackgroundColor(R.color.colorAccent);
        putBackground();
        putIcon();

        if(typedArray!=null){
            typedArray.recycle();
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void putBackground() {
        loadShapeAttributes();

       GradientDrawable shape = (GradientDrawable) rootLayout.getBackground().mutate();

        if (strokeWidth > 0) {
            shape.setStroke(strokeWidth, strokeColor);
        }
       if (cornerRadius > -1) {
           shape.setCornerRadius(cornerRadius);
        }
        if (backgroundColor != 0) {
            Log.v("qqqq","color fi");
            shape.setColor(backgroundColor);
        }
        rootLayout.setBackground(shape);
    }





    private void loadShapeAttributes() {
        if (style == 0) {
            return;
        }

        int defaultBackgroundColor = ContextCompat.getColor(context, R.color.default_background_color);
        int defaultCornerRadius = (int) context.getResources().getDimension(R.dimen.default_corner_radius);


        backgroundColor = typedArray.getColor(R.styleable.DStyleToast_stColorBackground, defaultBackgroundColor);
        cornerRadius = (int) typedArray.getDimension(R.styleable.DStyleToast_stRadius, defaultCornerRadius);

        length = typedArray.getInt(R.styleable.DStyleToast_stLength, 0);


        if (typedArray.hasValue(R.styleable.DStyleToast_stStrokeColor) && typedArray.hasValue(R.styleable.DStyleToast_stStrokeWidth)) {
            strokeWidth = (int) typedArray.getDimension(R.styleable.DStyleToast_stStrokeWidth, 0);
            strokeColor = typedArray.getColor(R.styleable.DStyleToast_stStrokeColor, Color.TRANSPARENT);
        }
    }

    public static class Bulider{
        private float cornerRadius = -1;
        private int backgroundColor;
        private int strokeColor;
        private int strokeWidth;
        private int iconStart;
        private int iconEnd;
        private int textColor;
        private int font;
        private int length;
        private float textSize;
        private boolean solidBackground;
        private boolean textBold;
        private String text;
        private int gravity = Gravity.BOTTOM;
        private DStyleToast toast;
        private  Context context;

public  Bulider(Context ctx){
    this.context=ctx;
}

        public Bulider() {

        }

        public Bulider setCornerRadius(int cornerRadius) {
            this.cornerRadius = cornerRadius;
            return this;
        }


        public Bulider setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Bulider setStrokeColor(int strokeColor) {
            this.strokeColor = strokeColor;
            return this;
        }

        public Bulider setStrokeWidth(int strokeWidth) {
            this.strokeWidth = strokeWidth;
            return this;
        }

        public Bulider setIconStart(int iconStart) {
            this.iconStart = iconStart;
            return this;
        }

        public Bulider setIconEnd(int iconEnd) {
            this.iconEnd = iconEnd;
            return this;
        }

        public Bulider setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Bulider setFont(int font) {
            this.font = font;
            return this;
        }

        public Bulider setLength(int length) {
            this.length = length;
            return this;
        }

        public Bulider setTextSize(float textSize) {
            this.textSize = textSize;
            return this;
        }

        public Bulider setSolidBackground(boolean solidBackground) {
            this.solidBackground = solidBackground;
            return this;
        }

        public Bulider setTextBold(boolean textBold) {
            this.textBold = textBold;
            return this;
        }

        public Bulider setText(String text) {
            this.text = text;
            return this;
        }

        public Bulider setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public Bulider setContext(Context context) {
            this.context = context;
            return this;
        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public void show(){
            toast=new DStyleToast(this);
            toast.show();
        }
    }
}
