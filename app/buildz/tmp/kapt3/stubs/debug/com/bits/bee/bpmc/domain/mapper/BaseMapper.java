package com.bits.bee.bpmc.domain.mapper;

import java.lang.System;

/**
 * Created by aldi on 20/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H&\u00a2\u0006\u0002\u0010\bJ\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0002H&\u00a2\u0006\u0002\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/bits/bee/bpmc/domain/mapper/BaseMapper;", "Db", "Domain", "Network", "", "()V", "fromDbToDomain", "model", "(Ljava/lang/Object;)Ljava/lang/Object;", "fromDomainToDb", "fromNetworkToDb", "app_debug"})
public abstract class BaseMapper<Db extends java.lang.Object, Domain extends java.lang.Object, Network extends java.lang.Object> {
    
    public BaseMapper() {
        super();
    }
    
    public abstract Domain fromDbToDomain(Db model);
    
    public abstract Db fromDomainToDb(Domain model);
    
    public abstract Db fromNetworkToDb(Network model);
}