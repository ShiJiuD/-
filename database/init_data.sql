-- =====================================================
-- 东丹服饰 — 产品模块初始数据
-- =====================================================

-- ===================== 产品主表 =====================
INSERT INTO product (id, category_id, name, cover_image, image_keyword, material, moq, price_hint, description, is_visible, sort_order, view_count, create_time, update_time) VALUES
(1,  1, '纯棉立领工作服',       'http://38.76.195.85/images/products/cotton-collar.jpg',      '纯棉立领工作服',       '纯棉斜纹布',   100, '¥85-120/件',   '精选新疆长绒棉，立领设计挺括有型，适合电子厂、食品厂、实验室等洁净环境。透气不闷汗，久穿不起球。',  1, 1, 326, NOW(), NOW()),
(2,  1, '防静电夏装工衣',       'http://38.76.195.85/images/products/anti-static-summer.jpg',  '防静电夏装工衣',       '防静电面料',    50, '¥120-160/件',  '导电丝嵌织工艺，表面电阻 10⁶~10⁸Ω，符合 GB 12014 标准。夏季轻薄款，袖口可调节。',           1, 2, 189, NOW(), NOW()),
(3,  1, '阻燃焊工防护服',       'http://38.76.195.85/images/products/fire-resistant.jpg',     '阻燃焊工防护服',       '芳纶阻燃布',    30, '¥280-350/套',  '芳纶 1414 面料，阻燃等级 A 级，耐高温 800℃。立体剪裁，焊接飞溅不粘附。',                   1, 3, 97,  NOW(), NOW()),
(4,  2, '高端商务 Polo 衫',     'http://38.76.195.85/images/products/business-polo.jpg',      '高端商务 Polo 衫',     '丝光棉',        200, '¥65-90/件',   '80支丝光棉，珠地网眼编织，不掉色不变形。左胸可刺绣企业 logo，适合银行/保险/物业。',         1, 1, 452, NOW(), NOW()),
(5,  2, '透气速干文化衫',       'http://38.76.195.85/images/products/quick-dry-tshirt.jpg',  '透气速干文化衫',       'CoolMax 速干面料', 100, '¥35-55/件',   'CoolMax 科技面料，吸湿排汗 3 秒速干。适合团建、展会、促销活动统一着装。',                   1, 2, 278, NOW(), NOW()),
(6,  2, '防风防水冲锋衣',       'http://38.76.195.85/images/products/windbreaker.jpg',        '防风防水冲锋衣',       '三层复合面料',   50, '¥180-260/件',  '外层防风防水透湿，内层抓绒可拆卸。YKK 拉链，压胶工艺，适合户外作业、物流配送。',             1, 3, 163, NOW(), NOW()),
(7,  3, '反光条环卫马甲',       'http://38.76.195.85/images/products/reflective-vest.jpg',    '反光条环卫马甲',       '涤纶网眼布',    200, '¥18-28/件',   '前后 5cm 宽高亮反光条，360° 无死角反光。网眼面料夏季透气，拉链+魔术贴双闭合。',             1, 1, 512, NOW(), NOW()),
(8,  3, '一次性无尘连体服',     'http://38.76.195.85/images/products/cleanroom-coverall.jpg', '一次性无尘连体服',     'SMS 无纺布',     500, '¥8-15/件',    'SMS 三层复合无纺布，防尘防静电。连帽连脚设计，弹性袖口脚口，适合无尘车间、喷涂作业。',       1, 2, 234, NOW(), NOW()),
(9,  3, '防酸碱化工防护服',     'http://38.76.195.85/images/products/chemical-suit.jpg',      '防酸碱化工防护服',     'PVC 复合布',      20, '¥320-450/套',  'PVC 双面涂覆，耐 98% 浓硫酸渗透 ≥60min。双层门襟+热合缝，通过 CE 认证。',                 1, 3, 56,  NOW(), NOW()),
(10, 4, '厨师双排扣工作服',     'http://38.76.195.85/images/products/chef-coat.jpg',          '厨师双排扣工作服',     '全棉珠帆布',     50, '¥70-100/件',  '双排扣设计可正反两穿，弄脏一面翻过来继续用。耐用珠帆布，耐高温水洗 200 次不缩水。',          1, 1, 198, NOW(), NOW()),
(11, 4, '酒店大堂迎宾制服',     'http://38.76.195.85/images/products/hotel-uniform.jpg',      '酒店大堂迎宾制服',     '毛涤混纺',       30, '¥280-400/套',  '70%羊毛+30%涤纶，挺括垂感好。男女款各 3 个版型，可定制刺绣工牌+酒店 logo。',               1, 2, 87,  NOW(), NOW()),
(12, 4, '医疗白大褂长袖款',     'http://38.76.195.85/images/products/lab-coat.jpg',           '医疗白大褂长袖款',     '涤棉府绸',       100, '¥55-75/件',   '65%涤 35%棉府绸，抗皱免烫。3 个口袋+侧开口，袖口松紧可选，适合医院/诊所/实验室。',         1, 3, 341, NOW(), NOW());

-- ===================== 产品规格 =====================
INSERT INTO product_spec (product_id, spec_label, spec_value, sort_order) VALUES
-- 纯棉立领工作服
(1, '面料成分',   '100%纯棉',       1),
(1, '克重',       '220g/㎡',        2),
(1, '尺码范围',   'S~5XL',          3),
(1, '颜色',       '藏青/灰色/卡其', 4),
(1, '适用季节',   '四季通用',       5),

-- 防静电夏装工衣
(2, '面料成分',   '99%涤+1%导电丝',  1),
(2, '表面电阻',   '10⁶~10⁸Ω',        2),
(2, '尺码范围',   'M~4XL',           3),
(2, '颜色',       '白色/浅蓝',       4),

-- 阻燃焊工防护服
(3, '面料成分',   '芳纶1414',         1),
(3, '阻燃等级',   'A级（GB 8965.1）', 2),
(3, '耐温',       '≤800℃',          3),
(3, '尺码范围',   'M~3XL',           4),

-- 高端商务 Polo 衫
(4, '面料成分',   '80支丝光棉',       1),
(4, '克重',       '200g/㎡',         2),
(4, '尺码范围',   'XS~4XL',          3),
(4, '颜色',       '白/黑/藏青/酒红', 4),

-- 透气速干文化衫
(5, '面料成分',   '100% CoolMax 聚酯', 1),
(5, '克重',       '160g/㎡',           2),
(5, '尺码范围',   'S~5XL',             3),
(5, '颜色可选',   '12色',              4),

-- 防风防水冲锋衣
(6, '面料',       '三层复合（表布+膜+里布）', 1),
(6, '防水指数',   '10000mm',                  2),
(6, '透湿指数',   '8000g/㎡/24h',             3),
(6, '尺码范围',   'M~4XL',                    4),

-- 反光条环卫马甲
(7, '面料',       '涤纶网眼布',       1),
(7, '反光条宽度', '5cm',              2),
(7, '尺码',       '均码/大码',        3),
(7, '颜色',       '荧光黄/荧光橙',    4),

-- 一次性无尘连体服
(8, '面料',       'SMS 三层无纺布',   1),
(8, '克重',       '50g/㎡',           2),
(8, '尺码',       'M~3XL',            3),
(8, '包装',       '独立真空包装',     4),

-- 防酸碱化工防护服
(9, '面料',         'PVC 双面涂覆布',   1),
(9, '耐酸渗透时间', '≥60min（98%浓硫酸）', 2),
(9, '缝制工艺',     '高频热合',         3),
(9, '认证',         'CE 0120',          4),

-- 厨师双排扣工作服
(10, '面料',        '全棉珠帆布',     1),
(10, '克重',        '280g/㎡',        2),
(10, '尺码',        'S~3XL',          3),
(10, '耐洗次数',    '≥200次工业洗涤', 4),

-- 酒店大堂迎宾制服
(11, '面料',        '70%羊毛+30%涤纶', 1),
(11, '克重',        '260g/㎡',         2),
(11, '尺码',        '量身定制',        3),
(11, '配件',        '含领结/领花/工牌套', 4),

-- 医疗白大褂长袖款
(12, '面料',        '65涤35棉府绸',   1),
(12, '克重',        '180g/㎡',        2),
(12, '尺码',        'XS~5XL',         3),
(12, '颜色',        '白色/浅蓝/粉色', 4);

-- ===================== 产品图片 =====================
INSERT INTO product_image (product_id, image_url, label, sort_order, create_time) VALUES
-- 纯棉立领工作服
(1, 'http://38.76.195.85/images/products/cotton-collar-front.jpg',  '正面图', 1, NOW()),
(1, 'http://38.76.195.85/images/products/cotton-collar-back.jpg',   '背面图', 2, NOW()),
(1, 'http://38.76.195.85/images/products/cotton-collar-detail.jpg', '领口细节', 3, NOW()),

-- 防静电夏装工衣
(2, 'http://38.76.195.85/images/products/anti-static-front.jpg',  '正面图', 1, NOW()),
(2, 'http://38.76.195.85/images/products/anti-static-side.jpg',   '侧面图', 2, NOW()),

-- 阻燃焊工防护服
(3, 'http://38.76.195.85/images/products/fire-resistant-front.jpg',  '正面图', 1, NOW()),
(3, 'http://38.76.195.85/images/products/fire-resistant-detail.jpg', '阻燃测试', 2, NOW()),

-- 高端商务 Polo 衫
(4, 'http://38.76.195.85/images/products/business-polo-white.jpg',  '白色款',   1, NOW()),
(4, 'http://38.76.195.85/images/products/business-polo-navy.jpg',   '藏青款',   2, NOW()),
(4, 'http://38.76.195.85/images/products/business-polo-logo.jpg',   '刺绣logo', 3, NOW()),

-- 透气速干文化衫
(5, 'http://38.76.195.85/images/products/tshirt-front.jpg',  '正面图', 1, NOW()),
(5, 'http://38.76.195.85/images/products/tshirt-color.jpg',  '12色色卡', 2, NOW()),

-- 防风防水冲锋衣
(6, 'http://38.76.195.85/images/products/windbreaker-front.jpg',  '正面图', 1, NOW()),
(6, 'http://38.76.195.85/images/products/windbreaker-back.jpg',   '背面图', 2, NOW()),
(6, 'http://38.76.195.85/images/products/windbreaker-liner.jpg',  '可拆内胆', 3, NOW()),

-- 反光条环卫马甲
(7, 'http://38.76.195.85/images/products/reflective-front.jpg',  '正面图', 1, NOW()),
(7, 'http://38.76.195.85/images/products/reflective-night.jpg',  '夜间反光效果', 2, NOW()),

-- 一次性无尘连体服
(8, 'http://38.76.195.85/images/products/coverall-front.jpg',  '正面图', 1, NOW()),
(8, 'http://38.76.195.85/images/products/coverall-pack.jpg',   '包装图', 2, NOW()),

-- 防酸碱化工防护服
(9, 'http://38.76.195.85/images/products/chemical-front.jpg',  '正面图', 1, NOW()),
(9, 'http://38.76.195.85/images/products/chemical-test.jpg',   '耐酸测试', 2, NOW()),

-- 厨师双排扣工作服
(10, 'http://38.76.195.85/images/products/chef-white.jpg', '白色款', 1, NOW()),
(10, 'http://38.76.195.85/images/products/chef-detail.jpg', '纽扣细节', 2, NOW()),

-- 酒店大堂迎宾制服
(11, 'http://38.76.195.85/images/products/hotel-male.jpg',   '男款', 1, NOW()),
(11, 'http://38.76.195.85/images/products/hotel-female.jpg',  '女款', 2, NOW()),

-- 医疗白大褂长袖款
(12, 'http://38.76.195.85/images/products/labcoat-white.jpg', '白色款', 1, NOW()),
(12, 'http://38.76.195.85/images/products/labcoat-pocket.jpg', '口袋细节', 2, NOW());
