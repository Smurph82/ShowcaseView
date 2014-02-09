package com.espian.showcaseview.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;

import com.espian.showcaseview.ShowcaseView;

public class PointAnimator {

	/**
	 * 
	 * @param object
	 * @param xMethod
	 * @param yMethod
	 * @param values
	 * @return
	 */
    public static Animator ofPoints(Object object, String xMethod, String yMethod, Point... values) {
        AnimatorSet set = new AnimatorSet();
        int[] xValues = new int[values.length];
        int[] yValues = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            xValues[i] = values[i].x;
            yValues[i] = values[i].y;
        }
        ObjectAnimator xAnimator = ObjectAnimator.ofInt(object, xMethod, xValues);
        ObjectAnimator yAnimator = ObjectAnimator.ofInt(object, yMethod, yValues);
        set.playTogether(xAnimator, yAnimator);
        return set;
    }

    /**
     * 
     * @param showcaseView
     * @param values
     * @return
     */
    public static Animator ofPoints(ShowcaseView showcaseView, Point... values) {
        return ofPoints(showcaseView, "showcaseX", "showcaseY", values);
    }

//    /**
//     * 
//     * @param showcaseView
//     * @param toX
//     * @param toY
//     * @param values
//     * @return
//     */
//    public static Animator ofPoints(ShowcaseView showcaseView, float toX, float toY, Point... values) {
//    	showcaseView.getScaleMultiplier();
//        return ofPoints(showcaseView, toX, toY, "showcaseX", "showcaseY", values);
//    }
//    
//	/**
//	 * 
//	 * @param object
//	 * @param xMethod
//	 * @param yMethod
//	 * @param values
//	 * @return
//	 */
//    public static Animator ofPoints(Object object, float toX, float toY, String xMethod, String yMethod, Point... values) {
//        AnimatorSet set = new AnimatorSet();
//        int[] xValues = new int[values.length];
//        int[] yValues = new int[values.length];
//        for (int i = 0; i < values.length; i++) {
//            xValues[i] = values[i].x;
//            yValues[i] = values[i].y;
//        }
//        ObjectAnimator xAnimator = ObjectAnimator.ofInt(object, xMethod, xValues);
//        ObjectAnimator yAnimator = ObjectAnimator.ofInt(object, yMethod, yValues);
//        
//        ObjectAnimator xScale = ObjectAnimator.ofFloat(object, "scaleX", toX);
//        ObjectAnimator yScale = ObjectAnimator.ofFloat(object, "scaleY", toY);
//        set.playTogether(xAnimator, yAnimator, xScale, yScale);
//        return set;
//    }

}
