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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bits.bee.bpmc.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRekapSesiBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout clTotalRekap;

  @NonNull
  public final LinearLayout lLDetail;

  @NonNull
  public final LinearLayout lLRekapEmpty;

  @NonNull
  public final LinearLayout linearLayout5;

  @NonNull
  public final TextView pemasukanTotal;

  @NonNull
  public final RecyclerView rvRekapSesi;

  private FragmentRekapSesiBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout clTotalRekap, @NonNull LinearLayout lLDetail,
      @NonNull LinearLayout lLRekapEmpty, @NonNull LinearLayout linearLayout5,
      @NonNull TextView pemasukanTotal, @NonNull RecyclerView rvRekapSesi) {
    this.rootView = rootView;
    this.clTotalRekap = clTotalRekap;
    this.lLDetail = lLDetail;
    this.lLRekapEmpty = lLRekapEmpty;
    this.linearLayout5 = linearLayout5;
    this.pemasukanTotal = pemasukanTotal;
    this.rvRekapSesi = rvRekapSesi;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRekapSesiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRekapSesiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_rekap_sesi, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRekapSesiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cl_total_rekap;
      ConstraintLayout clTotalRekap = ViewBindings.findChildViewById(rootView, id);
      if (clTotalRekap == null) {
        break missingId;
      }

      id = R.id.lL_detail;
      LinearLayout lLDetail = ViewBindings.findChildViewById(rootView, id);
      if (lLDetail == null) {
        break missingId;
      }

      id = R.id.lL_rekap_empty;
      LinearLayout lLRekapEmpty = ViewBindings.findChildViewById(rootView, id);
      if (lLRekapEmpty == null) {
        break missingId;
      }

      id = R.id.linearLayout5;
      LinearLayout linearLayout5 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout5 == null) {
        break missingId;
      }

      id = R.id.pemasukan_total;
      TextView pemasukanTotal = ViewBindings.findChildViewById(rootView, id);
      if (pemasukanTotal == null) {
        break missingId;
      }

      id = R.id.rv_rekap_sesi;
      RecyclerView rvRekapSesi = ViewBindings.findChildViewById(rootView, id);
      if (rvRekapSesi == null) {
        break missingId;
      }

      return new FragmentRekapSesiBinding((ConstraintLayout) rootView, clTotalRekap, lLDetail,
          lLRekapEmpty, linearLayout5, pemasukanTotal, rvRekapSesi);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}