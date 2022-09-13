// Generated by view binder compiler. Do not edit!
package com.bits.bee.bpmc.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class FragmentDetailBukaKasirBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnBukaKasir;

  @NonNull
  public final EditText etModal;

  @NonNull
  public final TextView textView60;

  @NonNull
  public final TextView textView64;

  @NonNull
  public final TextView textView65;

  @NonNull
  public final TextView textView66;

  @NonNull
  public final TextView textView67;

  @NonNull
  public final TextView textView68;

  @NonNull
  public final TextView textView69;

  @NonNull
  public final TextView textView70;

  @NonNull
  public final TextView tvCabang;

  @NonNull
  public final TextView tvKasir;

  @NonNull
  public final TextView tvMulaiOperasional;

  @NonNull
  public final TextView tvShift;

  @NonNull
  public final TextView tvUserKasir;

  @NonNull
  public final View view5;

  private FragmentDetailBukaKasirBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btnBukaKasir, @NonNull EditText etModal, @NonNull TextView textView60,
      @NonNull TextView textView64, @NonNull TextView textView65, @NonNull TextView textView66,
      @NonNull TextView textView67, @NonNull TextView textView68, @NonNull TextView textView69,
      @NonNull TextView textView70, @NonNull TextView tvCabang, @NonNull TextView tvKasir,
      @NonNull TextView tvMulaiOperasional, @NonNull TextView tvShift,
      @NonNull TextView tvUserKasir, @NonNull View view5) {
    this.rootView = rootView;
    this.btnBukaKasir = btnBukaKasir;
    this.etModal = etModal;
    this.textView60 = textView60;
    this.textView64 = textView64;
    this.textView65 = textView65;
    this.textView66 = textView66;
    this.textView67 = textView67;
    this.textView68 = textView68;
    this.textView69 = textView69;
    this.textView70 = textView70;
    this.tvCabang = tvCabang;
    this.tvKasir = tvKasir;
    this.tvMulaiOperasional = tvMulaiOperasional;
    this.tvShift = tvShift;
    this.tvUserKasir = tvUserKasir;
    this.view5 = view5;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDetailBukaKasirBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDetailBukaKasirBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_detail_buka_kasir, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDetailBukaKasirBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnBukaKasir;
      Button btnBukaKasir = ViewBindings.findChildViewById(rootView, id);
      if (btnBukaKasir == null) {
        break missingId;
      }

      id = R.id.etModal;
      EditText etModal = ViewBindings.findChildViewById(rootView, id);
      if (etModal == null) {
        break missingId;
      }

      id = R.id.textView60;
      TextView textView60 = ViewBindings.findChildViewById(rootView, id);
      if (textView60 == null) {
        break missingId;
      }

      id = R.id.textView64;
      TextView textView64 = ViewBindings.findChildViewById(rootView, id);
      if (textView64 == null) {
        break missingId;
      }

      id = R.id.textView65;
      TextView textView65 = ViewBindings.findChildViewById(rootView, id);
      if (textView65 == null) {
        break missingId;
      }

      id = R.id.textView66;
      TextView textView66 = ViewBindings.findChildViewById(rootView, id);
      if (textView66 == null) {
        break missingId;
      }

      id = R.id.textView67;
      TextView textView67 = ViewBindings.findChildViewById(rootView, id);
      if (textView67 == null) {
        break missingId;
      }

      id = R.id.textView68;
      TextView textView68 = ViewBindings.findChildViewById(rootView, id);
      if (textView68 == null) {
        break missingId;
      }

      id = R.id.textView69;
      TextView textView69 = ViewBindings.findChildViewById(rootView, id);
      if (textView69 == null) {
        break missingId;
      }

      id = R.id.textView70;
      TextView textView70 = ViewBindings.findChildViewById(rootView, id);
      if (textView70 == null) {
        break missingId;
      }

      id = R.id.tvCabang;
      TextView tvCabang = ViewBindings.findChildViewById(rootView, id);
      if (tvCabang == null) {
        break missingId;
      }

      id = R.id.tvKasir;
      TextView tvKasir = ViewBindings.findChildViewById(rootView, id);
      if (tvKasir == null) {
        break missingId;
      }

      id = R.id.tvMulaiOperasional;
      TextView tvMulaiOperasional = ViewBindings.findChildViewById(rootView, id);
      if (tvMulaiOperasional == null) {
        break missingId;
      }

      id = R.id.tvShift;
      TextView tvShift = ViewBindings.findChildViewById(rootView, id);
      if (tvShift == null) {
        break missingId;
      }

      id = R.id.tvUserKasir;
      TextView tvUserKasir = ViewBindings.findChildViewById(rootView, id);
      if (tvUserKasir == null) {
        break missingId;
      }

      id = R.id.view5;
      View view5 = ViewBindings.findChildViewById(rootView, id);
      if (view5 == null) {
        break missingId;
      }

      return new FragmentDetailBukaKasirBinding((ConstraintLayout) rootView, btnBukaKasir, etModal,
          textView60, textView64, textView65, textView66, textView67, textView68, textView69,
          textView70, tvCabang, tvKasir, tvMulaiOperasional, tvShift, tvUserKasir, view5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}