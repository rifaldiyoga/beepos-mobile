// Generated by view binder compiler. Do not edit!
package com.bits.bee.bpmc.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bits.bee.bpmc.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAddonBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText etQty;

  @NonNull
  public final ImageView imageView7;

  @NonNull
  public final ImageView ivMinus;

  @NonNull
  public final ImageView ivPlus;

  @NonNull
  public final ItemSelectionBinding layoutVariant;

  @NonNull
  public final LinearLayout llNext;

  @NonNull
  public final LinearLayout llQty;

  @NonNull
  public final NestedScrollView nestedScrollView;

  @NonNull
  public final RecyclerView rvListAddOn;

  @NonNull
  public final TextView tvQty;

  @NonNull
  public final TextView tvSubtotal;

  private FragmentAddonBinding(@NonNull ConstraintLayout rootView, @NonNull EditText etQty,
      @NonNull ImageView imageView7, @NonNull ImageView ivMinus, @NonNull ImageView ivPlus,
      @NonNull ItemSelectionBinding layoutVariant, @NonNull LinearLayout llNext,
      @NonNull LinearLayout llQty, @NonNull NestedScrollView nestedScrollView,
      @NonNull RecyclerView rvListAddOn, @NonNull TextView tvQty, @NonNull TextView tvSubtotal) {
    this.rootView = rootView;
    this.etQty = etQty;
    this.imageView7 = imageView7;
    this.ivMinus = ivMinus;
    this.ivPlus = ivPlus;
    this.layoutVariant = layoutVariant;
    this.llNext = llNext;
    this.llQty = llQty;
    this.nestedScrollView = nestedScrollView;
    this.rvListAddOn = rvListAddOn;
    this.tvQty = tvQty;
    this.tvSubtotal = tvSubtotal;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAddonBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAddonBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_addon, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAddonBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.etQty;
      EditText etQty = ViewBindings.findChildViewById(rootView, id);
      if (etQty == null) {
        break missingId;
      }

      id = R.id.imageView7;
      ImageView imageView7 = ViewBindings.findChildViewById(rootView, id);
      if (imageView7 == null) {
        break missingId;
      }

      id = R.id.ivMinus;
      ImageView ivMinus = ViewBindings.findChildViewById(rootView, id);
      if (ivMinus == null) {
        break missingId;
      }

      id = R.id.ivPlus;
      ImageView ivPlus = ViewBindings.findChildViewById(rootView, id);
      if (ivPlus == null) {
        break missingId;
      }

      id = R.id.layoutVariant;
      View layoutVariant = ViewBindings.findChildViewById(rootView, id);
      if (layoutVariant == null) {
        break missingId;
      }
      ItemSelectionBinding binding_layoutVariant = ItemSelectionBinding.bind(layoutVariant);

      id = R.id.llNext;
      LinearLayout llNext = ViewBindings.findChildViewById(rootView, id);
      if (llNext == null) {
        break missingId;
      }

      id = R.id.llQty;
      LinearLayout llQty = ViewBindings.findChildViewById(rootView, id);
      if (llQty == null) {
        break missingId;
      }

      id = R.id.nestedScrollView;
      NestedScrollView nestedScrollView = ViewBindings.findChildViewById(rootView, id);
      if (nestedScrollView == null) {
        break missingId;
      }

      id = R.id.rvListAddOn;
      RecyclerView rvListAddOn = ViewBindings.findChildViewById(rootView, id);
      if (rvListAddOn == null) {
        break missingId;
      }

      id = R.id.tvQty;
      TextView tvQty = ViewBindings.findChildViewById(rootView, id);
      if (tvQty == null) {
        break missingId;
      }

      id = R.id.tvSubtotal;
      TextView tvSubtotal = ViewBindings.findChildViewById(rootView, id);
      if (tvSubtotal == null) {
        break missingId;
      }

      return new FragmentAddonBinding((ConstraintLayout) rootView, etQty, imageView7, ivMinus,
          ivPlus, binding_layoutVariant, llNext, llQty, nestedScrollView, rvListAddOn, tvQty,
          tvSubtotal);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}