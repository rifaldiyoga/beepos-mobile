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

public final class ItemRekapSesiBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout clContent;

  @NonNull
  public final LinearLayout lLContentMember;

  @NonNull
  public final LinearLayout lLContentTipeTrans;

  @NonNull
  public final LinearLayout lLRekapSesi;

  @NonNull
  public final TextView tvRekapWaktu;

  @NonNull
  public final TextView tvUserKasir;

  @NonNull
  public final TextView tvtotalRekap;

  private ItemRekapSesiBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout clContent, @NonNull LinearLayout lLContentMember,
      @NonNull LinearLayout lLContentTipeTrans, @NonNull LinearLayout lLRekapSesi,
      @NonNull TextView tvRekapWaktu, @NonNull TextView tvUserKasir,
      @NonNull TextView tvtotalRekap) {
    this.rootView = rootView;
    this.clContent = clContent;
    this.lLContentMember = lLContentMember;
    this.lLContentTipeTrans = lLContentTipeTrans;
    this.lLRekapSesi = lLRekapSesi;
    this.tvRekapWaktu = tvRekapWaktu;
    this.tvUserKasir = tvUserKasir;
    this.tvtotalRekap = tvtotalRekap;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemRekapSesiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemRekapSesiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_rekap_sesi, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemRekapSesiBinding bind(@NonNull View rootView) {
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

      id = R.id.lL_content_tipeTrans;
      LinearLayout lLContentTipeTrans = ViewBindings.findChildViewById(rootView, id);
      if (lLContentTipeTrans == null) {
        break missingId;
      }

      id = R.id.lL_rekap_sesi;
      LinearLayout lLRekapSesi = ViewBindings.findChildViewById(rootView, id);
      if (lLRekapSesi == null) {
        break missingId;
      }

      id = R.id.tvRekap_waktu;
      TextView tvRekapWaktu = ViewBindings.findChildViewById(rootView, id);
      if (tvRekapWaktu == null) {
        break missingId;
      }

      id = R.id.tv_user_kasir;
      TextView tvUserKasir = ViewBindings.findChildViewById(rootView, id);
      if (tvUserKasir == null) {
        break missingId;
      }

      id = R.id.tvtotal_rekap;
      TextView tvtotalRekap = ViewBindings.findChildViewById(rootView, id);
      if (tvtotalRekap == null) {
        break missingId;
      }

      return new ItemRekapSesiBinding((ConstraintLayout) rootView, clContent, lLContentMember,
          lLContentTipeTrans, lLRekapSesi, tvRekapWaktu, tvUserKasir, tvtotalRekap);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}