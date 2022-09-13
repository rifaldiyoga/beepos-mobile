// Generated by view binder compiler. Do not edit!
package com.bits.bee.bpmc.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bits.bee.bpmc.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDetailTransaksiPenjualanBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnCetak;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ConstraintLayout constraintLayout2;

  @NonNull
  public final RecyclerView rvList;

  @NonNull
  public final TextView textView73;

  @NonNull
  public final TextView textView74;

  @NonNull
  public final TextView textView75;

  @NonNull
  public final TextView textView77;

  @NonNull
  public final TextView textView78;

  @NonNull
  public final TextView textView79;

  @NonNull
  public final TextView textView80;

  @NonNull
  public final TextView textView81;

  @NonNull
  public final TextView textView82;

  @NonNull
  public final TextView textView83;

  @NonNull
  public final TextView textView84;

  @NonNull
  public final TextView tvChannel;

  @NonNull
  public final TextView tvDiskon;

  @NonNull
  public final TextView tvJenisPembayaran;

  @NonNull
  public final TextView tvKasir;

  @NonNull
  public final TextView tvMember;

  @NonNull
  public final TextView tvPajak;

  @NonNull
  public final TextView tvPembulatan;

  @NonNull
  public final TextView tvSubtotal;

  @NonNull
  public final TextView tvTanggal;

  @NonNull
  public final TextView tvTotal;

  @NonNull
  public final View view6;

  @NonNull
  public final View view7;

  private FragmentDetailTransaksiPenjualanBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btnCetak, @NonNull ConstraintLayout constraintLayout,
      @NonNull ConstraintLayout constraintLayout2, @NonNull RecyclerView rvList,
      @NonNull TextView textView73, @NonNull TextView textView74, @NonNull TextView textView75,
      @NonNull TextView textView77, @NonNull TextView textView78, @NonNull TextView textView79,
      @NonNull TextView textView80, @NonNull TextView textView81, @NonNull TextView textView82,
      @NonNull TextView textView83, @NonNull TextView textView84, @NonNull TextView tvChannel,
      @NonNull TextView tvDiskon, @NonNull TextView tvJenisPembayaran, @NonNull TextView tvKasir,
      @NonNull TextView tvMember, @NonNull TextView tvPajak, @NonNull TextView tvPembulatan,
      @NonNull TextView tvSubtotal, @NonNull TextView tvTanggal, @NonNull TextView tvTotal,
      @NonNull View view6, @NonNull View view7) {
    this.rootView = rootView;
    this.btnCetak = btnCetak;
    this.constraintLayout = constraintLayout;
    this.constraintLayout2 = constraintLayout2;
    this.rvList = rvList;
    this.textView73 = textView73;
    this.textView74 = textView74;
    this.textView75 = textView75;
    this.textView77 = textView77;
    this.textView78 = textView78;
    this.textView79 = textView79;
    this.textView80 = textView80;
    this.textView81 = textView81;
    this.textView82 = textView82;
    this.textView83 = textView83;
    this.textView84 = textView84;
    this.tvChannel = tvChannel;
    this.tvDiskon = tvDiskon;
    this.tvJenisPembayaran = tvJenisPembayaran;
    this.tvKasir = tvKasir;
    this.tvMember = tvMember;
    this.tvPajak = tvPajak;
    this.tvPembulatan = tvPembulatan;
    this.tvSubtotal = tvSubtotal;
    this.tvTanggal = tvTanggal;
    this.tvTotal = tvTotal;
    this.view6 = view6;
    this.view7 = view7;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDetailTransaksiPenjualanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDetailTransaksiPenjualanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_detail_transaksi_penjualan, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDetailTransaksiPenjualanBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCetak;
      Button btnCetak = ViewBindings.findChildViewById(rootView, id);
      if (btnCetak == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.constraintLayout2;
      ConstraintLayout constraintLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout2 == null) {
        break missingId;
      }

      id = R.id.rvList;
      RecyclerView rvList = ViewBindings.findChildViewById(rootView, id);
      if (rvList == null) {
        break missingId;
      }

      id = R.id.textView73;
      TextView textView73 = ViewBindings.findChildViewById(rootView, id);
      if (textView73 == null) {
        break missingId;
      }

      id = R.id.textView74;
      TextView textView74 = ViewBindings.findChildViewById(rootView, id);
      if (textView74 == null) {
        break missingId;
      }

      id = R.id.textView75;
      TextView textView75 = ViewBindings.findChildViewById(rootView, id);
      if (textView75 == null) {
        break missingId;
      }

      id = R.id.textView77;
      TextView textView77 = ViewBindings.findChildViewById(rootView, id);
      if (textView77 == null) {
        break missingId;
      }

      id = R.id.textView78;
      TextView textView78 = ViewBindings.findChildViewById(rootView, id);
      if (textView78 == null) {
        break missingId;
      }

      id = R.id.textView79;
      TextView textView79 = ViewBindings.findChildViewById(rootView, id);
      if (textView79 == null) {
        break missingId;
      }

      id = R.id.textView80;
      TextView textView80 = ViewBindings.findChildViewById(rootView, id);
      if (textView80 == null) {
        break missingId;
      }

      id = R.id.textView81;
      TextView textView81 = ViewBindings.findChildViewById(rootView, id);
      if (textView81 == null) {
        break missingId;
      }

      id = R.id.textView82;
      TextView textView82 = ViewBindings.findChildViewById(rootView, id);
      if (textView82 == null) {
        break missingId;
      }

      id = R.id.textView83;
      TextView textView83 = ViewBindings.findChildViewById(rootView, id);
      if (textView83 == null) {
        break missingId;
      }

      id = R.id.textView84;
      TextView textView84 = ViewBindings.findChildViewById(rootView, id);
      if (textView84 == null) {
        break missingId;
      }

      id = R.id.tvChannel;
      TextView tvChannel = ViewBindings.findChildViewById(rootView, id);
      if (tvChannel == null) {
        break missingId;
      }

      id = R.id.tvDiskon;
      TextView tvDiskon = ViewBindings.findChildViewById(rootView, id);
      if (tvDiskon == null) {
        break missingId;
      }

      id = R.id.tvJenisPembayaran;
      TextView tvJenisPembayaran = ViewBindings.findChildViewById(rootView, id);
      if (tvJenisPembayaran == null) {
        break missingId;
      }

      id = R.id.tvKasir;
      TextView tvKasir = ViewBindings.findChildViewById(rootView, id);
      if (tvKasir == null) {
        break missingId;
      }

      id = R.id.tvMember;
      TextView tvMember = ViewBindings.findChildViewById(rootView, id);
      if (tvMember == null) {
        break missingId;
      }

      id = R.id.tvPajak;
      TextView tvPajak = ViewBindings.findChildViewById(rootView, id);
      if (tvPajak == null) {
        break missingId;
      }

      id = R.id.tvPembulatan;
      TextView tvPembulatan = ViewBindings.findChildViewById(rootView, id);
      if (tvPembulatan == null) {
        break missingId;
      }

      id = R.id.tvSubtotal;
      TextView tvSubtotal = ViewBindings.findChildViewById(rootView, id);
      if (tvSubtotal == null) {
        break missingId;
      }

      id = R.id.tvTanggal;
      TextView tvTanggal = ViewBindings.findChildViewById(rootView, id);
      if (tvTanggal == null) {
        break missingId;
      }

      id = R.id.tvTotal;
      TextView tvTotal = ViewBindings.findChildViewById(rootView, id);
      if (tvTotal == null) {
        break missingId;
      }

      id = R.id.view6;
      View view6 = ViewBindings.findChildViewById(rootView, id);
      if (view6 == null) {
        break missingId;
      }

      id = R.id.view7;
      View view7 = ViewBindings.findChildViewById(rootView, id);
      if (view7 == null) {
        break missingId;
      }

      return new FragmentDetailTransaksiPenjualanBinding((ConstraintLayout) rootView, btnCetak,
          constraintLayout, constraintLayout2, rvList, textView73, textView74, textView75,
          textView77, textView78, textView79, textView80, textView81, textView82, textView83,
          textView84, tvChannel, tvDiskon, tvJenisPembayaran, tvKasir, tvMember, tvPajak,
          tvPembulatan, tvSubtotal, tvTanggal, tvTotal, view6, view7);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}