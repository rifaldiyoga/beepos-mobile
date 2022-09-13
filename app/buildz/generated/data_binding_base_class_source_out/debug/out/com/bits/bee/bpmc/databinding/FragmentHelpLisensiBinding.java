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

public final class FragmentHelpLisensiBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView fragmentInvoiceBtnBatal;

  @NonNull
  public final TextView fragmentInvoiceBtnDraft;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout6;

  @NonNull
  public final LinearLayout rLBtnBottom;

  @NonNull
  public final LinearLayout rLDefine;

  @NonNull
  public final LinearLayout rLLainnya;

  @NonNull
  public final LinearLayout rLTop;

  @NonNull
  public final TextView tVNamaDevice;

  @NonNull
  public final TextView tVNamaPerangkat;

  @NonNull
  public final TextView tVSerialLisensi;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView tvJenisLisensi;

  @NonNull
  public final TextView tvNamaDb;

  @NonNull
  public final TextView tvNoLisensi;

  @NonNull
  public final TextView tvTglBerakhir;

  @NonNull
  public final TextView tvVersiBpm;

  @NonNull
  public final TextView txtDefine2;

  @NonNull
  public final TextView txtDefine3;

  @NonNull
  public final TextView txtDefine4;

  @NonNull
  public final TextView txtTitle2;

  private FragmentHelpLisensiBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView fragmentInvoiceBtnBatal, @NonNull TextView fragmentInvoiceBtnDraft,
      @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout6,
      @NonNull LinearLayout rLBtnBottom, @NonNull LinearLayout rLDefine,
      @NonNull LinearLayout rLLainnya, @NonNull LinearLayout rLTop, @NonNull TextView tVNamaDevice,
      @NonNull TextView tVNamaPerangkat, @NonNull TextView tVSerialLisensi,
      @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4,
      @NonNull TextView textView5, @NonNull TextView tvJenisLisensi, @NonNull TextView tvNamaDb,
      @NonNull TextView tvNoLisensi, @NonNull TextView tvTglBerakhir, @NonNull TextView tvVersiBpm,
      @NonNull TextView txtDefine2, @NonNull TextView txtDefine3, @NonNull TextView txtDefine4,
      @NonNull TextView txtTitle2) {
    this.rootView = rootView;
    this.fragmentInvoiceBtnBatal = fragmentInvoiceBtnBatal;
    this.fragmentInvoiceBtnDraft = fragmentInvoiceBtnDraft;
    this.linearLayout = linearLayout;
    this.linearLayout6 = linearLayout6;
    this.rLBtnBottom = rLBtnBottom;
    this.rLDefine = rLDefine;
    this.rLLainnya = rLLainnya;
    this.rLTop = rLTop;
    this.tVNamaDevice = tVNamaDevice;
    this.tVNamaPerangkat = tVNamaPerangkat;
    this.tVSerialLisensi = tVSerialLisensi;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.tvJenisLisensi = tvJenisLisensi;
    this.tvNamaDb = tvNamaDb;
    this.tvNoLisensi = tvNoLisensi;
    this.tvTglBerakhir = tvTglBerakhir;
    this.tvVersiBpm = tvVersiBpm;
    this.txtDefine2 = txtDefine2;
    this.txtDefine3 = txtDefine3;
    this.txtDefine4 = txtDefine4;
    this.txtTitle2 = txtTitle2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHelpLisensiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHelpLisensiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_help_lisensi, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHelpLisensiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.fragment_invoice_btnBatal;
      TextView fragmentInvoiceBtnBatal = ViewBindings.findChildViewById(rootView, id);
      if (fragmentInvoiceBtnBatal == null) {
        break missingId;
      }

      id = R.id.fragment_invoice_btnDraft;
      TextView fragmentInvoiceBtnDraft = ViewBindings.findChildViewById(rootView, id);
      if (fragmentInvoiceBtnDraft == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.linearLayout6;
      LinearLayout linearLayout6 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout6 == null) {
        break missingId;
      }

      id = R.id.rL_btn_bottom;
      LinearLayout rLBtnBottom = ViewBindings.findChildViewById(rootView, id);
      if (rLBtnBottom == null) {
        break missingId;
      }

      id = R.id.rL_define;
      LinearLayout rLDefine = ViewBindings.findChildViewById(rootView, id);
      if (rLDefine == null) {
        break missingId;
      }

      id = R.id.rL_lainnya;
      LinearLayout rLLainnya = ViewBindings.findChildViewById(rootView, id);
      if (rLLainnya == null) {
        break missingId;
      }

      id = R.id.rL_top;
      LinearLayout rLTop = ViewBindings.findChildViewById(rootView, id);
      if (rLTop == null) {
        break missingId;
      }

      id = R.id.tV_nama_device;
      TextView tVNamaDevice = ViewBindings.findChildViewById(rootView, id);
      if (tVNamaDevice == null) {
        break missingId;
      }

      id = R.id.tV_nama_perangkat;
      TextView tVNamaPerangkat = ViewBindings.findChildViewById(rootView, id);
      if (tVNamaPerangkat == null) {
        break missingId;
      }

      id = R.id.tV_serial_lisensi;
      TextView tVSerialLisensi = ViewBindings.findChildViewById(rootView, id);
      if (tVSerialLisensi == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.tv_jenis_lisensi;
      TextView tvJenisLisensi = ViewBindings.findChildViewById(rootView, id);
      if (tvJenisLisensi == null) {
        break missingId;
      }

      id = R.id.tv_nama_db;
      TextView tvNamaDb = ViewBindings.findChildViewById(rootView, id);
      if (tvNamaDb == null) {
        break missingId;
      }

      id = R.id.tv_no_lisensi;
      TextView tvNoLisensi = ViewBindings.findChildViewById(rootView, id);
      if (tvNoLisensi == null) {
        break missingId;
      }

      id = R.id.tv_tgl_berakhir;
      TextView tvTglBerakhir = ViewBindings.findChildViewById(rootView, id);
      if (tvTglBerakhir == null) {
        break missingId;
      }

      id = R.id.tv_versi_bpm;
      TextView tvVersiBpm = ViewBindings.findChildViewById(rootView, id);
      if (tvVersiBpm == null) {
        break missingId;
      }

      id = R.id.txtDefine2;
      TextView txtDefine2 = ViewBindings.findChildViewById(rootView, id);
      if (txtDefine2 == null) {
        break missingId;
      }

      id = R.id.txtDefine3;
      TextView txtDefine3 = ViewBindings.findChildViewById(rootView, id);
      if (txtDefine3 == null) {
        break missingId;
      }

      id = R.id.txtDefine4;
      TextView txtDefine4 = ViewBindings.findChildViewById(rootView, id);
      if (txtDefine4 == null) {
        break missingId;
      }

      id = R.id.txtTitle2;
      TextView txtTitle2 = ViewBindings.findChildViewById(rootView, id);
      if (txtTitle2 == null) {
        break missingId;
      }

      return new FragmentHelpLisensiBinding((ConstraintLayout) rootView, fragmentInvoiceBtnBatal,
          fragmentInvoiceBtnDraft, linearLayout, linearLayout6, rLBtnBottom, rLDefine, rLLainnya,
          rLTop, tVNamaDevice, tVNamaPerangkat, tVSerialLisensi, textView2, textView3, textView4,
          textView5, tvJenisLisensi, tvNamaDb, tvNoLisensi, tvTglBerakhir, tvVersiBpm, txtDefine2,
          txtDefine3, txtDefine4, txtTitle2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}