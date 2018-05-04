package by.torymo.navigationmenuitem;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NavigationMenuItem extends LinearLayout {

    private ImageView icon;
    private TextView text;

    private boolean checkable = false;

    private int iconId;
    private int iconTint;
    private int checkedColor;
    private int pressedColor;
    private ColorStateList textColor;
    private String sText;

    private boolean isCreated;
    private Context context;

    public NavigationMenuItem(Context context) {
        super(context);
        init(context,null, 0);
    }

    public NavigationMenuItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs, 0);
    }

    public NavigationMenuItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NavigationMenuItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs, defStyleAttr);
    }

    private void init(final Context context, final AttributeSet attrs, final int defStyleAttr) {

        this.context = context;

        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(inflater == null) return;

        inflater.inflate(R.layout.navigation_menu_item, this);

        icon = findViewById(R.id.ivIcon);
        text = findViewById(R.id.tvText);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NavigationMenuItem, defStyleAttr, 0);

        iconId = a.getResourceId(R.styleable.NavigationMenuItem_navItemIcon, 0);
        iconTint = a.getColor(R.styleable.NavigationMenuItem_navItemIconTint, 0);
        checkedColor = a.getColor(R.styleable.NavigationMenuItem_navCheckedItemTextColor, 0);
        pressedColor = a.getColor(R.styleable.NavigationMenuItem_navItemPressedColor, getResources().getColor(R.color.pressed_color));
        sText = a.getString(R.styleable.NavigationMenuItem_navItemText);
        checkable = a.getBoolean(R.styleable.NavigationMenuItem_navItemCheckable, checkable);

//        TypedValue iconTintValue = new TypedValue();
//        a.getValue(R.styleable.NavigationMenuItem_navItemIconTint, iconTintValue);
//        iconTint  = 0;
//        if (iconTintValue.type == TypedValue.TYPE_REFERENCE) {
//            iconTint = iconTintValue.resourceId;
//        } else {
//            iconTint = iconTintValue.data;
//        }

        a.recycle();

        textColor = text.getTextColors();
    }



    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isCreated) {
            buildView();
            isCreated = true;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (!isCreated) {
            buildView();
            isCreated = true;
        }
    }

    private void buildView(){
        text.setText(sText);

        icon.setImageResource(iconId);
        icon.setColorFilter(iconTint, android.graphics.PorterDuff.Mode.SRC_IN);
    }

    public void setChecked(boolean checked){
        if(!checkable || text == null) return;
        if(checked){
            text.setTextColor(checkedColor);

        }else {
            text.setTextColor(textColor);
        }
    }

}
