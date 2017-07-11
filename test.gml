graph
[
  node
  [
    id o2
    label "blk_file/dev2/block"
  ]
  node
  [
    id o3
    label "blk_file/dev3/block"
  ]
  node
  [
    id o1
    label "blk_file/dev1/block"
  ]
  node
  [
    id o4
    label "blk_file/dev4/block"
  ]
  node
  [
    id s2
    label "eu.chainfire.triangleaway"
  ]
  node
  [
    id s1
    label "de.robv.android.xposed.installer"
  ]
  node
  [
    id s4
    label "/system/xbin/busybox"
  ]
  node
  [
    id s3
    label "/system/bin/toolbox-dd"
  ]
  edge
  [
    source s1
    target o1
    label open
  ]
  edge
  [
    source s2
    target o1
    label open
  ]
  edge
  [
    source s3
    target o2
    label open
  ]
  edge
  [
    source s4
    target o2
    label open
  ]
  edge
  [
    source s1
    target o3
    label read
  ]
  edge
  [
    source s2
    target o3
    label read
  ]
  edge
  [
    source s3
    target o4
    label read
  ]
  edge
  [
    source s4
    target o4
    label read
  ]
]
