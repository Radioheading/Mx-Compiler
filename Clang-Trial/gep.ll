; ModuleID = 'gep.cpp'
source_filename = "gep.cpp"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

%class.A = type { i32, i32 }

$_ZN1A1bEv = comdat any

; Function Attrs: mustprogress noinline norecurse optnone uwtable
define dso_local noundef i32 @main() #0 {
entry:
  %retval = alloca i32, align 4
  %c = alloca i32, align 4
  %x = alloca [10 x %class.A], align 16
  %y = alloca %class.A, align 4
  store i32 0, ptr %retval, align 4
  store i32 1, ptr %c, align 4
  %arrayidx = getelementptr inbounds [10 x %class.A], ptr %x, i64 0, i64 1
  %call = call noundef i32 @_ZN1A1bEv(ptr noundef nonnull align 4 dereferenceable(8) %arrayidx)
  %call1 = call noundef i32 @_ZN1A1bEv(ptr noundef nonnull align 4 dereferenceable(8) %y)
  %arrayidx2 = getelementptr inbounds [10 x %class.A], ptr %x, i64 0, i64 0
  %call3 = call noundef i32 @_ZN1A1bEv(ptr noundef nonnull align 4 dereferenceable(8) %arrayidx2)
  ret i32 %call3
}

; Function Attrs: mustprogress noinline nounwind optnone uwtable
define linkonce_odr dso_local noundef i32 @_ZN1A1bEv(ptr noundef nonnull align 4 dereferenceable(8) %this) #1 comdat align 2 {
entry:
  %this.addr = alloca ptr, align 8
  store ptr %this, ptr %this.addr, align 8
  %this1 = load ptr, ptr %this.addr, align 8
  %d = getelementptr inbounds %class.A, ptr %this1, i32 0, i32 1
  %0 = load i32, ptr %d, align 4
  ret i32 %0
}

attributes #0 = { mustprogress noinline norecurse optnone uwtable "frame-pointer"="all" "min-legal-vector-width"="0" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cmov,+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "tune-cpu"="generic" }
attributes #1 = { mustprogress noinline nounwind optnone uwtable "frame-pointer"="all" "min-legal-vector-width"="0" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cmov,+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "tune-cpu"="generic" }

!llvm.module.flags = !{!0, !1, !2, !3, !4}
!llvm.ident = !{!5}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{i32 8, !"PIC Level", i32 2}
!2 = !{i32 7, !"PIE Level", i32 2}
!3 = !{i32 7, !"uwtable", i32 2}
!4 = !{i32 7, !"frame-pointer", i32 2}
!5 = !{!"Ubuntu clang version 18.0.0 (++20230809052958+ade0aa6163e0-1~exp1~20230809173116.725)"}
