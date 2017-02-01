package com.aurelhubert.ahbottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;

/**
 * AHBottomNavigationItem
 * The item is display in the AHBottomNavigation layout
 */
public class AHBottomNavigationItem {

    private String title = "";

    private Drawable drawable;

    private Drawable inactiveDrawable;

    private int color = Color.GRAY;

    @StringRes
    private int titleRes = 0;

    @DrawableRes
    private int drawableRes = 0;

    @DrawableRes
    private int inactiveDrawableRes = 0;

    @ColorRes
    private int colorRes = 0;

    private boolean tintDrawableActive = true;

    private boolean tintDrawableInactive = true;

    /**
     * Constructor
     *
     * @param title    Title
     * @param resource Drawable resource
     */
    @Deprecated
    public AHBottomNavigationItem(String title, @DrawableRes int resource) {
        this.title = title;
        this.drawableRes = resource;
    }

    /**
     * @param title    Title
     * @param resource Drawable resource
     * @param color    Background color
     */
    @Deprecated
    public AHBottomNavigationItem(String title, @DrawableRes int resource, @ColorRes int color) {
        this.title = title;
        this.drawableRes = resource;
        this.color = color;
    }

    /**
     * Constructor
     *
     * @param titleRes    String resource
     * @param drawableRes Drawable resource
     * @param colorRes    Color resource
     */
    @Deprecated
    public AHBottomNavigationItem(@StringRes int titleRes, @DrawableRes int drawableRes, @ColorRes int colorRes) {
        this.titleRes = titleRes;
        this.drawableRes = drawableRes;
        this.colorRes = colorRes;
    }

    /**
     * Constructor
     *
     * @param title    String
     * @param drawable Drawable
     */
    @Deprecated
    public AHBottomNavigationItem(String title, Drawable drawable) {
        this.title = title;
        this.drawable = drawable;
    }

    /**
     * Constructor
     *
     * @param title    String
     * @param drawable Drawable
     * @param color    Color
     */
    @Deprecated
    public AHBottomNavigationItem(String title, Drawable drawable, @ColorInt int color) {
        this.title = title;
        this.drawable = drawable;
        this.color = color;
    }

    private AHBottomNavigationItem(
            String title,
            Drawable drawable,
            Drawable inactiveDrawable,
            @ColorInt int color,
            @StringRes int titleRes,
            @DrawableRes int drawableRes,
            @DrawableRes int inactiveDrawableRes,
            @ColorRes int colorRes,
            boolean tintDrawableActive,
            boolean tintDrawableInactive) {
        this.title = title;
        this.drawable = drawable;
        this.inactiveDrawable = inactiveDrawable;
        this.color = color;
        this.titleRes = titleRes;
        this.drawableRes = drawableRes;
        this.inactiveDrawableRes = inactiveDrawableRes;
        this.colorRes = colorRes;
        this.tintDrawableActive = tintDrawableActive;
        this.tintDrawableInactive = tintDrawableInactive;
    }

    public String getTitle(Context context) {
        if (titleRes != 0) {
            return context.getString(titleRes);
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.titleRes = 0;
    }

    public void setTitle(@StringRes int titleRes) {
        this.titleRes = titleRes;
        this.title = "";
    }

    public int getColor(Context context) {
        if (colorRes != 0) {
            return ContextCompat.getColor(context, colorRes);
        }
        return color;
    }

    public void setColor(@ColorInt int color) {
        this.color = color;
        this.colorRes = 0;
    }

    public void setColorRes(@ColorRes int colorRes) {
        this.colorRes = colorRes;
        this.color = 0;
    }

    public Drawable getDrawable(Context context) {
        if (drawableRes != 0) {
            try {
                return VectorDrawableCompat.create(context.getResources(), drawableRes, null);
            } catch (Resources.NotFoundException e) {
                return ContextCompat.getDrawable(context, drawableRes);
            }
        }
        return drawable;
    }

    public Drawable getDrawableInactive(Context context) {
        if (inactiveDrawableRes != 0) {
            try {
                return VectorDrawableCompat.create(context.getResources(), inactiveDrawableRes, null);
            } catch (Resources.NotFoundException e) {
                return ContextCompat.getDrawable(context, inactiveDrawableRes);
            }
        }
        return inactiveDrawable;
    }

    public void setDrawable(@DrawableRes int drawableRes) {
        this.drawableRes = drawableRes;
        this.drawable = null;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        this.drawableRes = 0;
    }

    public void setInactiveDrawable(@DrawableRes int drawableRes) {
        this.inactiveDrawableRes = drawableRes;
        this.inactiveDrawable = null;
    }

    public void setInactiveDrawable(Drawable drawable) {
        this.inactiveDrawable = drawable;
        this.inactiveDrawableRes = 0;
    }

    public boolean isTintDrawableActive() {
        return tintDrawableActive;
    }

    public void setTintDrawableActive(boolean tintDrawableActive) {
        this.tintDrawableActive = tintDrawableActive;
    }

    public boolean isTintDrawableInactive() {
        return tintDrawableInactive;
    }

    public void setTintDrawableInactive(boolean tintDrawableInactive) {
        this.tintDrawableInactive = tintDrawableInactive;
    }

    public static class Builder {

        private String title = "";

        private Drawable drawable;

        private Drawable inactiveDrawable;

        private int color = Color.GRAY;

        @StringRes
        private int titleRes = 0;

        @DrawableRes
        private int drawableRes = 0;

        @DrawableRes
        private int inactiveDrawableRes = 0;

        @ColorRes
        private int colorRes = 0;

        private boolean tintDrawableActive = true;

        private boolean tintDrawableInactive = true;

        public Builder(@StringRes int titleRes, @DrawableRes int resource) {
            this.titleRes = titleRes;
            this.drawableRes = resource;
        }

        public Builder(@StringRes int titleRes, Drawable drawable) {
            this.titleRes = titleRes;
            this.drawable = drawable;
        }

        public Builder(String title, @DrawableRes int resource) {
            this.title = title;
            this.drawableRes = resource;
        }

        public Builder(String title, Drawable drawable) {
            this.title = title;
            this.drawable = drawable;
        }

        public Builder setColor(@ColorInt int color) {
            this.color = color;
            this.colorRes = 0;
            return this;
        }

        public Builder setColorRes(@ColorRes int colorRes) {
            this.colorRes = colorRes;
            this.color = 0;
            return this;
        }

        public Builder setInactiveDrawable(@DrawableRes int drawableRes) {
            this.inactiveDrawableRes = drawableRes;
            this.inactiveDrawable = null;
            return this;
        }

        public Builder setInactiveDrawable(Drawable drawable) {
            this.inactiveDrawable = drawable;
            this.inactiveDrawableRes = 0;
            return this;
        }

        public Builder setTintDrawableActive(boolean tintDrawableActive) {
            this.tintDrawableActive = tintDrawableActive;
            return this;
        }

        public Builder setTintDrawableInactive(boolean tintDrawableInactive) {
            this.tintDrawableInactive = tintDrawableInactive;
            return this;
        }

        public AHBottomNavigationItem build() {
            return new AHBottomNavigationItem(
                    title, drawable, inactiveDrawable, color,
                    titleRes, drawableRes, inactiveDrawableRes, colorRes,
                    tintDrawableActive, tintDrawableInactive);
        }
    }
}
