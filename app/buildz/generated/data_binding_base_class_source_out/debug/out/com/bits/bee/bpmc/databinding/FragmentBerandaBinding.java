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
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bits.bee.bpmc.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentBerandaBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnBukaKasir;

  @NonNull
  public final Group groupPendapatan;

  @NonNull
  public final TextView textView61;

  @NonNull
  public final TextView tvDetail;

  @NonNull
  public final TextView tvGreeting;

  @NonNull
  public final TextView tvInfoKasir;

  @NonNull
  public final TextView tvKota;

  @NonNull
  public final TextView tvTotalPendapatan;

  private FragmentBerandaBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnBukaKasir,
      @NonNull Group groupPendapatan, @NonNull TextView textView61, @NonNull TextView tvDetail,
      @NonNull TextView tvGreeting, @NonNull TextView tvInfoKasir, @NonNull TextView tvKota,
      @NonNull TextView tvTotalPendapatan) {
    this.rootView = rootView;
    this.btnBukaKasir = btnBukaKasir;
    this.groupPendapatan = groupPendapatan;
    this.textView61 = textView61;
    this.tvDetail = tvDetail;
    this.tvGreeting = tvGreeting;
    this.tvInfoKasir = tvInfoKasir;
    this.tvKota = tvKota;
    this.tvTotalPendapatan = tvTotalPendapatan;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentBerandaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentBerandaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_beranda, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentBerandaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnBukaKasir;
      Button btnBukaKasir = ViewBindings.findChildViewById(rootView, id);
      if (btnBukaKasir == null) {
        break missingId;
      }

      id = R.id.groupPendapatan;
      Group groupPendapatan = ViewBindings.findChildViewById(rootView, id);
      if (groupPendapatan == null) {
        break missingId;
      }

      id = R.id.textView61;
      TextView textView61 = ViewBindings.findChildViewById(rootView, id);
      if (textView61 == null) {
        break missingId;
      }

      id = R.id.tvDetail;
      TextView tvDetail = ViewBindings.findChildViewById(rootView, id);
      if (tvDetail == null) {
        break missingId;
      }

      id = R.id.tvGreeting;
      TextView tvGreeting = ViewBindings.findChildViewById(rootView, id);
      if (tvGreeting == null) {
        break missingId;
      }

      id = R.id.tvInfoKasir;
      TextView tvInfoKasir = ViewBindings.findChildViewById(rootView, id);
      if (tvInfoKasir == null) {
        break missingId;
      }

      id = R.id.tvKota;
      TextView tvKota = ViewBindings.findChildViewById(rootView, id);
      if (tvKota == null) {
        break missingId;
      }

      id = R.id.tvTotalPendapatan;
      TextView tvTotalPendapatan = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalPendapatan == null) {
        break missingId;
      }

      return new FragmentBerandaBinding((ConstraintLayout) rootView, btnBukaKasir, groupPendapatan,
          textView61, tvDetail, tvGreeting, tvInfoKasir, tvKota, tvTotalPendapatan);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}