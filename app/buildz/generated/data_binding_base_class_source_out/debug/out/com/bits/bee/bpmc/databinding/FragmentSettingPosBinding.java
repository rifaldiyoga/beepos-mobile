// Generated by view binder compiler. Do not edit!
package com.bits.bee.bpmc.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bits.bee.bpmc.R;
import com.google.android.material.switchmaterial.SwitchMaterial;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSettingPosBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final ConstraintLayout clCustomer;

  @NonNull
  public final ConstraintLayout clJumlahMeja;

  @NonNull
  public final ConstraintLayout clKonfirmasiCustomer;

  @NonNull
  public final ConstraintLayout clMuatGambarProduk;

  @NonNull
  public final ConstraintLayout clMultiLine;

  @NonNull
  public final ConstraintLayout clOrientasi;

  @NonNull
  public final ConstraintLayout clPresetBukaKasir;

  @NonNull
  public final ConstraintLayout clRekapPerChannel;

  @NonNull
  public final ConstraintLayout clRekapPerFaktur;

  @NonNull
  public final ConstraintLayout clRekapProdukPerChannel;

  @NonNull
  public final ConstraintLayout clUkuranFont;

  @NonNull
  public final SwitchMaterial swKonfirmasiCust;

  @NonNull
  public final SwitchMaterial swMuatGambarProduk;

  @NonNull
  public final SwitchMaterial swMultiLine;

  @NonNull
  public final SwitchMaterial swRekapPerChannel;

  @NonNull
  public final SwitchMaterial swRekapPerCustomer;

  @NonNull
  public final TextView textView26;

  @NonNull
  public final TextView textView27;

  @NonNull
  public final TextView textView28;

  @NonNull
  public final TextView textView29;

  @NonNull
  public final TextView textView30;

  @NonNull
  public final TextView textView31;

  @NonNull
  public final TextView textView32;

  @NonNull
  public final TextView textView33;

  @NonNull
  public final TextView textView34;

  @NonNull
  public final TextView textView35;

  @NonNull
  public final TextView textView36;

  @NonNull
  public final TextView textView37;

  @NonNull
  public final TextView tvDetailJumlahMeja;

  @NonNull
  public final TextView tvDetailOrientasi;

  @NonNull
  public final TextView tvDetailPresetBukaKasir;

  @NonNull
  public final View vCustomer;

  @NonNull
  public final View vJumlahMeja;

  private FragmentSettingPosBinding(@NonNull NestedScrollView rootView,
      @NonNull ConstraintLayout clCustomer, @NonNull ConstraintLayout clJumlahMeja,
      @NonNull ConstraintLayout clKonfirmasiCustomer, @NonNull ConstraintLayout clMuatGambarProduk,
      @NonNull ConstraintLayout clMultiLine, @NonNull ConstraintLayout clOrientasi,
      @NonNull ConstraintLayout clPresetBukaKasir, @NonNull ConstraintLayout clRekapPerChannel,
      @NonNull ConstraintLayout clRekapPerFaktur, @NonNull ConstraintLayout clRekapProdukPerChannel,
      @NonNull ConstraintLayout clUkuranFont, @NonNull SwitchMaterial swKonfirmasiCust,
      @NonNull SwitchMaterial swMuatGambarProduk, @NonNull SwitchMaterial swMultiLine,
      @NonNull SwitchMaterial swRekapPerChannel, @NonNull SwitchMaterial swRekapPerCustomer,
      @NonNull TextView textView26, @NonNull TextView textView27, @NonNull TextView textView28,
      @NonNull TextView textView29, @NonNull TextView textView30, @NonNull TextView textView31,
      @NonNull TextView textView32, @NonNull TextView textView33, @NonNull TextView textView34,
      @NonNull TextView textView35, @NonNull TextView textView36, @NonNull TextView textView37,
      @NonNull TextView tvDetailJumlahMeja, @NonNull TextView tvDetailOrientasi,
      @NonNull TextView tvDetailPresetBukaKasir, @NonNull View vCustomer,
      @NonNull View vJumlahMeja) {
    this.rootView = rootView;
    this.clCustomer = clCustomer;
    this.clJumlahMeja = clJumlahMeja;
    this.clKonfirmasiCustomer = clKonfirmasiCustomer;
    this.clMuatGambarProduk = clMuatGambarProduk;
    this.clMultiLine = clMultiLine;
    this.clOrientasi = clOrientasi;
    this.clPresetBukaKasir = clPresetBukaKasir;
    this.clRekapPerChannel = clRekapPerChannel;
    this.clRekapPerFaktur = clRekapPerFaktur;
    this.clRekapProdukPerChannel = clRekapProdukPerChannel;
    this.clUkuranFont = clUkuranFont;
    this.swKonfirmasiCust = swKonfirmasiCust;
    this.swMuatGambarProduk = swMuatGambarProduk;
    this.swMultiLine = swMultiLine;
    this.swRekapPerChannel = swRekapPerChannel;
    this.swRekapPerCustomer = swRekapPerCustomer;
    this.textView26 = textView26;
    this.textView27 = textView27;
    this.textView28 = textView28;
    this.textView29 = textView29;
    this.textView30 = textView30;
    this.textView31 = textView31;
    this.textView32 = textView32;
    this.textView33 = textView33;
    this.textView34 = textView34;
    this.textView35 = textView35;
    this.textView36 = textView36;
    this.textView37 = textView37;
    this.tvDetailJumlahMeja = tvDetailJumlahMeja;
    this.tvDetailOrientasi = tvDetailOrientasi;
    this.tvDetailPresetBukaKasir = tvDetailPresetBukaKasir;
    this.vCustomer = vCustomer;
    this.vJumlahMeja = vJumlahMeja;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSettingPosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSettingPosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_setting_pos, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSettingPosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.clCustomer;
      ConstraintLayout clCustomer = ViewBindings.findChildViewById(rootView, id);
      if (clCustomer == null) {
        break missingId;
      }

      id = R.id.clJumlahMeja;
      ConstraintLayout clJumlahMeja = ViewBindings.findChildViewById(rootView, id);
      if (clJumlahMeja == null) {
        break missingId;
      }

      id = R.id.clKonfirmasiCustomer;
      ConstraintLayout clKonfirmasiCustomer = ViewBindings.findChildViewById(rootView, id);
      if (clKonfirmasiCustomer == null) {
        break missingId;
      }

      id = R.id.clMuatGambarProduk;
      ConstraintLayout clMuatGambarProduk = ViewBindings.findChildViewById(rootView, id);
      if (clMuatGambarProduk == null) {
        break missingId;
      }

      id = R.id.clMultiLine;
      ConstraintLayout clMultiLine = ViewBindings.findChildViewById(rootView, id);
      if (clMultiLine == null) {
        break missingId;
      }

      id = R.id.clOrientasi;
      ConstraintLayout clOrientasi = ViewBindings.findChildViewById(rootView, id);
      if (clOrientasi == null) {
        break missingId;
      }

      id = R.id.clPresetBukaKasir;
      ConstraintLayout clPresetBukaKasir = ViewBindings.findChildViewById(rootView, id);
      if (clPresetBukaKasir == null) {
        break missingId;
      }

      id = R.id.clRekapPerChannel;
      ConstraintLayout clRekapPerChannel = ViewBindings.findChildViewById(rootView, id);
      if (clRekapPerChannel == null) {
        break missingId;
      }

      id = R.id.clRekapPerFaktur;
      ConstraintLayout clRekapPerFaktur = ViewBindings.findChildViewById(rootView, id);
      if (clRekapPerFaktur == null) {
        break missingId;
      }

      id = R.id.clRekapProdukPerChannel;
      ConstraintLayout clRekapProdukPerChannel = ViewBindings.findChildViewById(rootView, id);
      if (clRekapProdukPerChannel == null) {
        break missingId;
      }

      id = R.id.clUkuranFont;
      ConstraintLayout clUkuranFont = ViewBindings.findChildViewById(rootView, id);
      if (clUkuranFont == null) {
        break missingId;
      }

      id = R.id.swKonfirmasiCust;
      SwitchMaterial swKonfirmasiCust = ViewBindings.findChildViewById(rootView, id);
      if (swKonfirmasiCust == null) {
        break missingId;
      }

      id = R.id.swMuatGambarProduk;
      SwitchMaterial swMuatGambarProduk = ViewBindings.findChildViewById(rootView, id);
      if (swMuatGambarProduk == null) {
        break missingId;
      }

      id = R.id.swMultiLine;
      SwitchMaterial swMultiLine = ViewBindings.findChildViewById(rootView, id);
      if (swMultiLine == null) {
        break missingId;
      }

      id = R.id.swRekapPerChannel;
      SwitchMaterial swRekapPerChannel = ViewBindings.findChildViewById(rootView, id);
      if (swRekapPerChannel == null) {
        break missingId;
      }

      id = R.id.swRekapPerCustomer;
      SwitchMaterial swRekapPerCustomer = ViewBindings.findChildViewById(rootView, id);
      if (swRekapPerCustomer == null) {
        break missingId;
      }

      id = R.id.textView26;
      TextView textView26 = ViewBindings.findChildViewById(rootView, id);
      if (textView26 == null) {
        break missingId;
      }

      id = R.id.textView27;
      TextView textView27 = ViewBindings.findChildViewById(rootView, id);
      if (textView27 == null) {
        break missingId;
      }

      id = R.id.textView28;
      TextView textView28 = ViewBindings.findChildViewById(rootView, id);
      if (textView28 == null) {
        break missingId;
      }

      id = R.id.textView29;
      TextView textView29 = ViewBindings.findChildViewById(rootView, id);
      if (textView29 == null) {
        break missingId;
      }

      id = R.id.textView30;
      TextView textView30 = ViewBindings.findChildViewById(rootView, id);
      if (textView30 == null) {
        break missingId;
      }

      id = R.id.textView31;
      TextView textView31 = ViewBindings.findChildViewById(rootView, id);
      if (textView31 == null) {
        break missingId;
      }

      id = R.id.textView32;
      TextView textView32 = ViewBindings.findChildViewById(rootView, id);
      if (textView32 == null) {
        break missingId;
      }

      id = R.id.textView33;
      TextView textView33 = ViewBindings.findChildViewById(rootView, id);
      if (textView33 == null) {
        break missingId;
      }

      id = R.id.textView34;
      TextView textView34 = ViewBindings.findChildViewById(rootView, id);
      if (textView34 == null) {
        break missingId;
      }

      id = R.id.textView35;
      TextView textView35 = ViewBindings.findChildViewById(rootView, id);
      if (textView35 == null) {
        break missingId;
      }

      id = R.id.textView36;
      TextView textView36 = ViewBindings.findChildViewById(rootView, id);
      if (textView36 == null) {
        break missingId;
      }

      id = R.id.textView37;
      TextView textView37 = ViewBindings.findChildViewById(rootView, id);
      if (textView37 == null) {
        break missingId;
      }

      id = R.id.tvDetailJumlahMeja;
      TextView tvDetailJumlahMeja = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailJumlahMeja == null) {
        break missingId;
      }

      id = R.id.tvDetailOrientasi;
      TextView tvDetailOrientasi = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailOrientasi == null) {
        break missingId;
      }

      id = R.id.tvDetailPresetBukaKasir;
      TextView tvDetailPresetBukaKasir = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailPresetBukaKasir == null) {
        break missingId;
      }

      id = R.id.vCustomer;
      View vCustomer = ViewBindings.findChildViewById(rootView, id);
      if (vCustomer == null) {
        break missingId;
      }

      id = R.id.vJumlahMeja;
      View vJumlahMeja = ViewBindings.findChildViewById(rootView, id);
      if (vJumlahMeja == null) {
        break missingId;
      }

      return new FragmentSettingPosBinding((NestedScrollView) rootView, clCustomer, clJumlahMeja,
          clKonfirmasiCustomer, clMuatGambarProduk, clMultiLine, clOrientasi, clPresetBukaKasir,
          clRekapPerChannel, clRekapPerFaktur, clRekapProdukPerChannel, clUkuranFont,
          swKonfirmasiCust, swMuatGambarProduk, swMultiLine, swRekapPerChannel, swRekapPerCustomer,
          textView26, textView27, textView28, textView29, textView30, textView31, textView32,
          textView33, textView34, textView35, textView36, textView37, tvDetailJumlahMeja,
          tvDetailOrientasi, tvDetailPresetBukaKasir, vCustomer, vJumlahMeja);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}