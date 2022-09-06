package com.bits.bee.bpmc.domain.model;

import java.lang.System;

/**
 * Created by aldi on 17/03/22.
 */
@kotlinx.parcelize.Parcelize()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0003\b\u009c\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\n\u0012\u0006\u0010\"\u001a\u00020\n\u0012\u0006\u0010#\u001a\u00020\n\u0012\u0006\u0010$\u001a\u00020\n\u0012\b\u0010%\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010&\u001a\u00020\n\u0012\u0006\u0010\'\u001a\u00020\u0005\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010*\u001a\u00020\u0005\u0012\u0006\u0010+\u001a\u00020\u0005\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010-\u001a\u00020\u0005\u0012\b\b\u0002\u0010.\u001a\u00020\u0005\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\b\u00100\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u00101\u001a\u00020\u0005\u00a2\u0006\u0002\u00102J\n\u0010\u0080\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0014H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00104J\n\u0010\u0089\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00104J\n\u0010\u008b\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00104J\n\u0010\u008e\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00104J\n\u0010\u0090\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u0095\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u0098\u0001\u001a\u00020\nH\u00c6\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\n\u0010\u009a\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00104J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u00a0\u0001\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\u0011\u0010\u00a1\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00104J\n\u0010\u00a2\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00a3\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00a4\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u00a5\u0001\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\n\u0010\u00a6\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u00a7\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u00a8\u0001\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\f\u0010\u00a9\u0001\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\n\u0010\u00aa\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u00e8\u0003\u0010\u00ac\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010&\u001a\u00020\n2\b\b\u0002\u0010\'\u001a\u00020\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u00101\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0003\u0010\u00ad\u0001J\n\u0010\u00ae\u0001\u001a\u00020\u0003H\u00d6\u0001J\u0016\u0010\u00af\u0001\u001a\u00020\u00052\n\u0010\u00b0\u0001\u001a\u0005\u0018\u00010\u00b1\u0001H\u00d6\u0003J\n\u0010\u00b2\u0001\u001a\u00020\u0003H\u00d6\u0001J\n\u0010\u00b3\u0001\u001a\u00020\nH\u00d6\u0001J\u001e\u0010\u00b4\u0001\u001a\u00030\u00b5\u00012\b\u0010\u00b6\u0001\u001a\u00030\u00b7\u00012\u0007\u0010\u00b8\u0001\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00107\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u001a\u0010\"\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010(\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00107\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u001c\u00100\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010;\"\u0004\bE\u0010=R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010;\"\u0004\bG\u0010=R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010;\"\u0004\bI\u0010=R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010N\"\u0004\bO\u0010PR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010N\"\u0004\bQ\u0010PR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010N\"\u0004\bR\u0010PR\u001a\u00101\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010N\"\u0004\bS\u0010PR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010N\"\u0004\bT\u0010PR\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010N\"\u0004\bU\u0010PR\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010N\"\u0004\bV\u0010PR\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010N\"\u0004\bW\u0010PR\u001a\u0010*\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010N\"\u0004\bX\u0010PR\u001a\u0010/\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010N\"\u0004\bY\u0010PR\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010N\"\u0004\bZ\u0010PR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010N\"\u0004\b[\u0010PR\u001a\u0010\'\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010N\"\u0004\b\\\u0010PR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010N\"\u0004\b]\u0010PR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010N\"\u0004\b^\u0010PR\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010N\"\u0004\b_\u0010PR\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010N\"\u0004\b`\u0010PR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010N\"\u0004\ba\u0010PR\u001a\u0010-\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010N\"\u0004\bb\u0010PR\u001c\u0010%\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010;\"\u0004\bd\u0010=R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00107\u001a\u0004\be\u00104\"\u0004\bf\u00106R\u001c\u0010)\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010A\"\u0004\bh\u0010CR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00107\u001a\u0004\bi\u00104\"\u0004\bj\u00106R\u001c\u0010,\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010A\"\u0004\bU\u0010CR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010A\"\u0004\bV\u0010CR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010A\"\u0004\bW\u0010CR\u001a\u0010!\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010;\"\u0004\bo\u0010=R\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010;\"\u0004\bq\u0010=R\u001a\u0010\u001f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010K\"\u0004\bs\u0010MR\u001a\u0010&\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010;\"\u0004\bu\u0010=R\u001a\u0010$\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010;\"\u0004\bw\u0010=R\u001a\u0010#\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u0010;\"\u0004\by\u0010=R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u0010;\"\u0004\b{\u0010=R\u001c\u0010\r\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u0010;\"\u0004\b}\u0010=R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00107\u001a\u0004\b~\u00104\"\u0004\b\u007f\u00106\u00a8\u0006\u00b9\u0001"}, d2 = {"Lcom/bits/bee/bpmc/domain/model/Promo;", "Landroid/os/Parcelable;", "id", "", "isActive", "", "isBranch", "branchId", "isPeriod", "startDate", "", "endDate", "isTime", "startTime", "endTime", "isDow", "dowExp", "isBpgrp", "offerType", "minAmt", "Ljava/math/BigDecimal;", "isTargetItem", "itemId", "isTargetItgrp", "itgrpId", "isTargetBrand", "brandId", "isTargetVendor", "vendorId", "isMinQty", "minQty", "priority", "isMinAmt", "note", "code", "promoType", "promoName", "itemDiscExp", "promoCat", "isPriceOveride", "dealItemId", "itemPrice", "isMinQtyMultiply", "isMaxQty", "maxQty", "isUsed", "isOn", "isMulti", "dealQty", "isDealSameItem", "(IZZLjava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/math/BigDecimal;ZLjava/lang/Integer;ZLjava/lang/Integer;ZLjava/lang/Integer;ZLjava/lang/Integer;ZLjava/math/BigDecimal;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/math/BigDecimal;ZZLjava/math/BigDecimal;ZZZLjava/math/BigDecimal;Z)V", "getBranchId", "()Ljava/lang/Integer;", "setBranchId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBrandId", "setBrandId", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getDealItemId", "setDealItemId", "getDealQty", "()Ljava/math/BigDecimal;", "setDealQty", "(Ljava/math/BigDecimal;)V", "getDowExp", "setDowExp", "getEndDate", "setEndDate", "getEndTime", "setEndTime", "getId", "()I", "setId", "(I)V", "()Z", "setActive", "(Z)V", "setBpgrp", "setBranch", "setDealSameItem", "setDow", "setMaxQty", "setMinAmt", "setMinQty", "setMinQtyMultiply", "setMulti", "setOn", "setPeriod", "setPriceOveride", "setTargetBrand", "setTargetItem", "setTargetItgrp", "setTargetVendor", "setTime", "setUsed", "getItemDiscExp", "setItemDiscExp", "getItemId", "setItemId", "getItemPrice", "setItemPrice", "getItgrpId", "setItgrpId", "getMaxQty", "getMinAmt", "getMinQty", "getNote", "setNote", "getOfferType", "setOfferType", "getPriority", "setPriority", "getPromoCat", "setPromoCat", "getPromoName", "setPromoName", "getPromoType", "setPromoType", "getStartDate", "setStartDate", "getStartTime", "setStartTime", "getVendorId", "setVendorId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component5", "component6", "component7", "component8", "component9", "copy", "(IZZLjava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/math/BigDecimal;ZLjava/lang/Integer;ZLjava/lang/Integer;ZLjava/lang/Integer;ZLjava/lang/Integer;ZLjava/math/BigDecimal;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/math/BigDecimal;ZZLjava/math/BigDecimal;ZZZLjava/math/BigDecimal;Z)Lcom/bits/bee/bpmc/domain/model/Promo;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class Promo implements android.os.Parcelable {
    private int id;
    private boolean isActive;
    private boolean isBranch;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer branchId;
    private boolean isPeriod;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String startDate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String endDate;
    private boolean isTime;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String startTime;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String endTime;
    private boolean isDow;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String dowExp;
    private boolean isBpgrp;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String offerType;
    @org.jetbrains.annotations.NotNull()
    private java.math.BigDecimal minAmt;
    private boolean isTargetItem;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer itemId;
    private boolean isTargetItgrp;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer itgrpId;
    private boolean isTargetBrand;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer brandId;
    private boolean isTargetVendor;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer vendorId;
    private boolean isMinQty;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal minQty;
    private int priority;
    private boolean isMinAmt;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String note;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String code;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String promoType;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String promoName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String itemDiscExp;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String promoCat;
    private boolean isPriceOveride;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer dealItemId;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal itemPrice;
    private boolean isMinQtyMultiply;
    private boolean isMaxQty;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal maxQty;
    private boolean isUsed;
    private boolean isOn;
    private boolean isMulti;
    @org.jetbrains.annotations.Nullable()
    private java.math.BigDecimal dealQty;
    private boolean isDealSameItem;
    public static final android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Promo> CREATOR = null;
    
    /**
     * Created by aldi on 17/03/22.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.model.Promo copy(int id, boolean isActive, boolean isBranch, @org.jetbrains.annotations.Nullable()
    java.lang.Integer branchId, boolean isPeriod, @org.jetbrains.annotations.Nullable()
    java.lang.String startDate, @org.jetbrains.annotations.Nullable()
    java.lang.String endDate, boolean isTime, @org.jetbrains.annotations.Nullable()
    java.lang.String startTime, @org.jetbrains.annotations.Nullable()
    java.lang.String endTime, boolean isDow, @org.jetbrains.annotations.Nullable()
    java.lang.String dowExp, boolean isBpgrp, @org.jetbrains.annotations.NotNull()
    java.lang.String offerType, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal minAmt, boolean isTargetItem, @org.jetbrains.annotations.Nullable()
    java.lang.Integer itemId, boolean isTargetItgrp, @org.jetbrains.annotations.Nullable()
    java.lang.Integer itgrpId, boolean isTargetBrand, @org.jetbrains.annotations.Nullable()
    java.lang.Integer brandId, boolean isTargetVendor, @org.jetbrains.annotations.Nullable()
    java.lang.Integer vendorId, boolean isMinQty, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal minQty, int priority, boolean isMinAmt, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String promoType, @org.jetbrains.annotations.NotNull()
    java.lang.String promoName, @org.jetbrains.annotations.Nullable()
    java.lang.String itemDiscExp, @org.jetbrains.annotations.NotNull()
    java.lang.String promoCat, boolean isPriceOveride, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dealItemId, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal itemPrice, boolean isMinQtyMultiply, boolean isMaxQty, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal maxQty, boolean isUsed, boolean isOn, boolean isMulti, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal dealQty, boolean isDealSameItem) {
        return null;
    }
    
    /**
     * Created by aldi on 17/03/22.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Created by aldi on 17/03/22.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created by aldi on 17/03/22.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Promo(int id, boolean isActive, boolean isBranch, @org.jetbrains.annotations.Nullable()
    java.lang.Integer branchId, boolean isPeriod, @org.jetbrains.annotations.Nullable()
    java.lang.String startDate, @org.jetbrains.annotations.Nullable()
    java.lang.String endDate, boolean isTime, @org.jetbrains.annotations.Nullable()
    java.lang.String startTime, @org.jetbrains.annotations.Nullable()
    java.lang.String endTime, boolean isDow, @org.jetbrains.annotations.Nullable()
    java.lang.String dowExp, boolean isBpgrp, @org.jetbrains.annotations.NotNull()
    java.lang.String offerType, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal minAmt, boolean isTargetItem, @org.jetbrains.annotations.Nullable()
    java.lang.Integer itemId, boolean isTargetItgrp, @org.jetbrains.annotations.Nullable()
    java.lang.Integer itgrpId, boolean isTargetBrand, @org.jetbrains.annotations.Nullable()
    java.lang.Integer brandId, boolean isTargetVendor, @org.jetbrains.annotations.Nullable()
    java.lang.Integer vendorId, boolean isMinQty, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal minQty, int priority, boolean isMinAmt, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String promoType, @org.jetbrains.annotations.NotNull()
    java.lang.String promoName, @org.jetbrains.annotations.Nullable()
    java.lang.String itemDiscExp, @org.jetbrains.annotations.NotNull()
    java.lang.String promoCat, boolean isPriceOveride, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dealItemId, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal itemPrice, boolean isMinQtyMultiply, boolean isMaxQty, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal maxQty, boolean isUsed, boolean isOn, boolean isMulti, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal dealQty, boolean isDealSameItem) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean isActive() {
        return false;
    }
    
    public final void setActive(boolean p0) {
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean isBranch() {
        return false;
    }
    
    public final void setBranch(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getBranchId() {
        return null;
    }
    
    public final void setBranchId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean isPeriod() {
        return false;
    }
    
    public final void setPeriod(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStartDate() {
        return null;
    }
    
    public final void setStartDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEndDate() {
        return null;
    }
    
    public final void setEndDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean isTime() {
        return false;
    }
    
    public final void setTime(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStartTime() {
        return null;
    }
    
    public final void setStartTime(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEndTime() {
        return null;
    }
    
    public final void setEndTime(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean isDow() {
        return false;
    }
    
    public final void setDow(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDowExp() {
        return null;
    }
    
    public final void setDowExp(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final boolean isBpgrp() {
        return false;
    }
    
    public final void setBpgrp(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOfferType() {
        return null;
    }
    
    public final void setOfferType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getMinAmt() {
        return null;
    }
    
    public final void setMinAmt(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal p0) {
    }
    
    public final boolean component16() {
        return false;
    }
    
    public final boolean isTargetItem() {
        return false;
    }
    
    public final void setTargetItem(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getItemId() {
        return null;
    }
    
    public final void setItemId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final boolean component18() {
        return false;
    }
    
    public final boolean isTargetItgrp() {
        return false;
    }
    
    public final void setTargetItgrp(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getItgrpId() {
        return null;
    }
    
    public final void setItgrpId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final boolean component20() {
        return false;
    }
    
    public final boolean isTargetBrand() {
        return false;
    }
    
    public final void setTargetBrand(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getBrandId() {
        return null;
    }
    
    public final void setBrandId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final boolean component22() {
        return false;
    }
    
    public final boolean isTargetVendor() {
        return false;
    }
    
    public final void setTargetVendor(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getVendorId() {
        return null;
    }
    
    public final void setVendorId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public final boolean component24() {
        return false;
    }
    
    public final boolean isMinQty() {
        return false;
    }
    
    public final void setMinQty(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getMinQty() {
        return null;
    }
    
    public final void setMinQty(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    public final int component26() {
        return 0;
    }
    
    public final int getPriority() {
        return 0;
    }
    
    public final void setPriority(int p0) {
    }
    
    public final boolean component27() {
        return false;
    }
    
    public final boolean isMinAmt() {
        return false;
    }
    
    public final void setMinAmt(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNote() {
        return null;
    }
    
    public final void setNote(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCode() {
        return null;
    }
    
    public final void setCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPromoType() {
        return null;
    }
    
    public final void setPromoType(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component31() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPromoName() {
        return null;
    }
    
    public final void setPromoName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component32() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getItemDiscExp() {
        return null;
    }
    
    public final void setItemDiscExp(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component33() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPromoCat() {
        return null;
    }
    
    public final void setPromoCat(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component34() {
        return false;
    }
    
    public final boolean isPriceOveride() {
        return false;
    }
    
    public final void setPriceOveride(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component35() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getDealItemId() {
        return null;
    }
    
    public final void setDealItemId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component36() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getItemPrice() {
        return null;
    }
    
    public final void setItemPrice(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    public final boolean component37() {
        return false;
    }
    
    public final boolean isMinQtyMultiply() {
        return false;
    }
    
    public final void setMinQtyMultiply(boolean p0) {
    }
    
    public final boolean component38() {
        return false;
    }
    
    public final boolean isMaxQty() {
        return false;
    }
    
    public final void setMaxQty(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component39() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getMaxQty() {
        return null;
    }
    
    public final void setMaxQty(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    public final boolean component40() {
        return false;
    }
    
    public final boolean isUsed() {
        return false;
    }
    
    public final void setUsed(boolean p0) {
    }
    
    public final boolean component41() {
        return false;
    }
    
    public final boolean isOn() {
        return false;
    }
    
    public final void setOn(boolean p0) {
    }
    
    public final boolean component42() {
        return false;
    }
    
    public final boolean isMulti() {
        return false;
    }
    
    public final void setMulti(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal component43() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.math.BigDecimal getDealQty() {
        return null;
    }
    
    public final void setDealQty(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal p0) {
    }
    
    public final boolean component44() {
        return false;
    }
    
    public final boolean isDealSameItem() {
        return false;
    }
    
    public final void setDealSameItem(boolean p0) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.bits.bee.bpmc.domain.model.Promo> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Promo createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.bits.bee.bpmc.domain.model.Promo[] newArray(int size) {
            return null;
        }
    }
}