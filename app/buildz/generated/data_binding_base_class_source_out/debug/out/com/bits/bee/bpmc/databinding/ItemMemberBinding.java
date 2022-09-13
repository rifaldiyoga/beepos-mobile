// Generated by view binder compiler. Do not edit!
package com.bits.bee.bpmc.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bits.bee.bpmc.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemMemberBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout clContent;

  @NonNull
  public final LinearLayout lLContentMember;

  @NonNull
  public final LinearLayout llDetailMember;

  @NonNull
  public final LinearLayout pidAvailable;

  @NonNull
  public final TextView tvNamaMember;

  @NonNull
  public final TextView tvNoTelp;

  private ItemMemberBinding(@NonNull ConstraintLayout rootView, @NonNull ConstraintLayout clContent,
      @NonNull LinearLayout lLContentMember, @NonNull LinearLayout llDetailMember,
      @NonNull LinearLayout pidAvailable, @NonNull TextView tvNamaMember,
      @NonNull TextView tvNoTelp) {
    this.rootView = rootView;
    this.clContent = clContent;
    this.lLContentMember = lLContentMember;
    this.llDetailMember = llDetailMember;
    this.pidAvailable = pidAvailable;
    this.tvNamaMember = tvNamaMember;
    this.tvNoTelp = tvNoTelp;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemMemberBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemMemberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_member, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemMemberBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout clContent = (ConstraintLayout) rootView;

      id = R.id.lL_content_member;
      LinearLayout lLContentMember = ViewBindings.findChildViewById(rootView, id);
      if (lLContentMember == null) {
        break missingId;
      }

      id = R.id.ll_detail_member;
      LinearLayout llDetailMember = ViewBindings.findChildViewById(rootView, id);
      if (llDetailMember == null) {
        break missingId;
      }

      id = R.id.pid_available;
      LinearLayout pidAvailable = ViewBindings.findChildViewById(rootView, id);
      if (pidAvailable == null) {
        break missingId;
      }

      id = R.id.tvNamaMember;
      TextView tvNamaMember = ViewBindings.findChildViewById(rootView, id);
      if (tvNamaMember == null) {
        break missingId;
      }

      id = R.id.tvNoTelp;
      TextView tvNoTelp = ViewBindings.findChildViewById(rootView, id);
      if (tvNoTelp == null) {
        break missingId;
      }

      return new ItemMemberBinding((ConstraintLayout) rootView, clContent, lLContentMember,
          llDetailMember, pidAvailable, tvNamaMember, tvNoTelp);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}