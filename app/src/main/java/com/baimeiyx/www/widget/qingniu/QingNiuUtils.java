package com.baimeiyx.www.widget.qingniu;

import com.baimeiyx.www.service.model.QingNiuBean;
import com.example.mrw.baimeiyouxuan.R;

/**
 * 轻牛健康工具类
 */
public class QingNiuUtils {

    private int level;
    private String info = null;
    private String levelMsg = null;
    private float sw;
    private float offset;
    private float lowLeverMaxValue;
    private float lowerLeverMaxValue;
    private float standardLevelMaxValue;
    private float highLevelMaxValue;

    private String level_1 = "严重偏低";
    private String level_2 = "偏低";
    private String level_3 = "正常";
    private String level_4 = "偏高";
    private String level_5 = "严重偏高";
    private int level_1_color = R.color.levelLower;
    private int level_2_color = R.color.levelLow;
    private int level_3_color = R.color.levelStandard;
    private int level_4_color = R.color.levelHigh;
    private int level_5_color = R.color.levelHigher;
    private int typeImg;
    private String typeName;

    // 体重
    public QingNiuBean getWeight(float height, float weight, int sex) {
        typeName = "体重";
        typeImg = R.drawable.ic_report_weight;
        if (sex == 1) {
            sw = (height - 80) * 0.7f;
        } else {
            sw = (height * 1.37f - 80) * 0.45f;
        }
        lowerLeverMaxValue = 0.8f * sw;
        lowLeverMaxValue = 0.9f * sw;
        standardLevelMaxValue = 1.1f * sw;
        highLevelMaxValue = 1.2f * sw;
        if (weight <= lowLeverMaxValue) {
            level = 1;
            info = "长期体重过轻会导致一系列的问题，如脱发，厌食症等，身体技能会下降，需要加强营养，多吃高蛋白食物，摄入更多的热量以增加体重。";
            levelMsg = "严重偏低";
        } else if (lowerLeverMaxValue < weight && weight < lowLeverMaxValue) {
            levelMsg = "偏低";
            level = 2;
            info = "体重偏轻，身体消瘦，建议坚强营养，平衡饮食，多吃高蛋白食物，摄入更多的热量以增加体重。";
        } else if (lowLeverMaxValue <= weight && weight <= standardLevelMaxValue) {
            level = 3;
            info = "恭喜您拥有理想的身体，保持合理健康的生活方式，适量参加运动，您就可以维持标准体重了。";
        } else if (standardLevelMaxValue < weight && weight <= highLevelMaxValue) {
            levelMsg = "偏高";
            level = 4;
            info = "体重偏重，略显肥胖，建议一周进行3-5次有氧运动，减少食物（米饭面食等）的摄入，增加高纤维粗粮比列。";
        } else {
            levelMsg = "严重偏高";
            level = 5;
            info = "体重严重超标，建议低脂，低胆固醇，高纤维膳食，补充多种维生素，增加运动量进行体重控制。";
        }

        offset = weight - sw;
        return setQingNiuBean(info, levelMsg, offset, "kg", level);
    }

    //获取bmi
    public QingNiuBean getBMI(float value, int sex) {
        typeName = "BMI";
        typeImg = R.drawable.ic_report_bmi;
        lowLeverMaxValue = 18.5f;
        standardLevelMaxValue = 25;
        if (value < 18.5) {
            levelMsg = "偏低";
            offset = value - 18.5f;
            level = 2;
            info = "需要提升体能健康增重，适当独吃高热量、高蛋白、高脂肪、多做力量运动如：举重、俯卧撑、仰卧起坐等。BMI:是指身体质量指数,国际上常用的衡量人体胖瘦程度以及是否健康的一个标准。";
        } else if (value >= 18.5 && value <= 25) {
            if (sex == 1) {
                info = "BMI达标，如果腰围也属于建议的尺寸男性（计算公式：身高(厘米)*1/2-10=标准的腰围(里面)）就更加理想了。BMI:是指身体质量指数,国际上常用的衡量人体胖瘦程度以及是否健康的一个标准。";
            } else {
                info = "BMI达标，如果腰围也属于建议的尺寸女性（计算公式：身高(厘米)*1/2-13=标准的腰围(里面)）就更加理想了。BMI:是指身体质量指数,国际上常用的衡量人体胖瘦程度以及是否健康的一个标准。";
            }
            level = 3;

        } else {
            levelMsg = "偏高";
            offset = value - 25;
            level = 4;
            info = "BMI超标,建议选择比较健康的方法减重,如控制饮食、改变不良的生活习惯和参加跑步、跳绳、打篮球、踢足球等消耗体能的运动。BMI:是指身体质量指数,国际上常用的衡量人体胖瘦程度以及是否健康的一个标准。";

        }
        return setQingNiuBean(info, levelMsg, offset, "", level);
    }

    // 体脂率
    public QingNiuBean getBodyFat(float value, int sex) {
        typeName = "体脂率";
        typeImg = R.drawable.ic_report_bodyfat;
        if (sex == 1) {
            lowLeverMaxValue = 11;
            standardLevelMaxValue = 21;
            highLevelMaxValue = 26;

        } else {
            lowLeverMaxValue = 21;
            standardLevelMaxValue = 31;
            highLevelMaxValue = 36;

        }
        if (value < lowLeverMaxValue) {
            level = 2;
            info = "当身体摄取到优良营养，并且令到小肠绒毛正常运作，就可以达到正常的脂肪比例。为了增重，食物最好以易消化、高蛋白、高热量为主。";
            offset = value - lowLeverMaxValue;
            levelMsg = "偏低";

        } else if (lowLeverMaxValue <= value && value <= standardLevelMaxValue) {
            level = 3;
            info = "目前您的体脂率处于标准范围，保持好的饮食方式和生活习惯是保持健康身材的最佳途径。";
        } else if (standardLevelMaxValue > value && value <= highLevelMaxValue) {
            offset = value - standardLevelMaxValue;
            level = 4;
            info = "要匀称不显胖，每日有氧运动要持续30分钟，体脂率才会开始燃烧，快走、慢跑、游泳、爬楼梯、骑自行车都是很好的选择。";
            levelMsg = "偏高";
        } else {
            offset = value - highLevelMaxValue;
            level = 5;
            info = "您的体内囤积了太多脂肪，必须检测血压、血糖、肝功能等情况，是否潜藏危害。赶快开始您的减肥大战，坚持饮食控制、运动及改变生活方式。";
            levelMsg = "严重偏高";
        }

        return setQingNiuBean(info, levelMsg, offset, "%", level);
    }

    // 体水分
    public QingNiuBean getBodyWater(float value, int sex) {
        typeName = "体水分";
        typeImg = R.drawable.ic_report_water;
        level_4 = "充足";
        level_4_color = R.color.levelFull;
        if (sex == 1) {
            lowLeverMaxValue = 55;
            standardLevelMaxValue = 65;

        } else {
            lowLeverMaxValue = 45;
            standardLevelMaxValue = 60;

        }
        if (value < lowLeverMaxValue) {
            levelMsg = "偏低";
            offset = value - lowLeverMaxValue;
            level = 2;
            info = "体水分率偏低，规律的饮食习惯和每天喝足8杯水可以维持正常的体水分水平，充足的水分可以促进代谢，带走废物和身体毒素。";
        } else if (value <= lowLeverMaxValue && value <= standardLevelMaxValue) {
            level = 3;
            info = "身体水分处于标准值，适量饮水，适当运动，均衡饮食，保持身体水分的平衡。";
        } else {
            levelMsg = "充足";
            offset = value - standardLevelMaxValue;
            level = 4;
            info = "身体水含量高,细胞活性高。充足的水分能帮助您更好地消化食物和吸收水分，并促进代谢，带走废物和毒素";
        }
        return setQingNiuBean(info, levelMsg, offset, "%", level);
    }

    // 骨骼肌率
    public QingNiuBean getSkeletalMuscle(float value, int sex) {
        typeName = "骨骼肌率";
        typeImg = R.drawable.ic_report_muscle;
        if (sex == 1) {
            lowLeverMaxValue = 49;
            standardLevelMaxValue = 59;
        } else {
            lowLeverMaxValue = 40;
            standardLevelMaxValue = 50;

        }
        if (value < lowLeverMaxValue) {
            levelMsg = "偏低";
            offset = value - lowLeverMaxValue;
            level = 2;
            info = "您的骨骼肌比率低于理想范围，跟多静态活动、不运动有关，会导致基础代谢率降低，腰酸背痛，力量下降，外在表现是发胖，也容易诱发心血管疾病。骨骼肌率：人体有多个肌肉组成，其中骨骼肌是可以通过锻炼增加的肌肉";
        } else if (value <= lowLeverMaxValue && value <= standardLevelMaxValue) {
            level = 3;
            info = "您的骨骼肌比率处于标准范围。运动量过少或者节食会导致肌肉流失，请保持适当的运动量和合理的饮食。骨骼肌率：人体有多个肌肉组成，其中骨骼肌是可以通过锻炼增加的肌肉";
        } else {
            levelMsg = "偏高";
            offset = value - standardLevelMaxValue;
            level = 4;
            info = "如果脂肪比例正常，您是一个比较喜欢运动的人，适当的骨骼肌比率能够显示您健壮的体型，但过高的骨骼肌比率可能户影响您的灵活性，如果"
                    + "脂肪比例偏低，您的身材可能偏瘦，平衡身体各项参数，您就能拥有健康标准的身材。骨骼肌率：人体有多个肌肉组成，其中骨骼肌是可以通过锻炼增加的肌肉";
        }
        return setQingNiuBean(info, levelMsg, offset, "%", level);
    }

    // 肌肉量
    public QingNiuBean getMuscle(int value, int height, int sex) {
        typeName = "肌肉量";
        typeImg = R.drawable.ic_report_muscle_mass;
        level_4 = "充足";
        level_4_color = R.color.levelFull;
        if (sex == 1) {
            if (height < 160) {
                lowLeverMaxValue = 38.5f;
                standardLevelMaxValue = 46.5f;

            } else if (height <= 160 && height <= 170) {
                lowLeverMaxValue = 44;
                standardLevelMaxValue = 52.4f;

            } else {
                lowLeverMaxValue = 49.4f;
                standardLevelMaxValue = 59.4f;
            }
        } else {
            if (height < 150) {
                lowLeverMaxValue = 29.1f;
                standardLevelMaxValue = 34.7f;
            } else if (height <= 150 && height <= 160) {
                lowLeverMaxValue = 32.9f;
                standardLevelMaxValue = 37.5f;

            } else {
                lowLeverMaxValue = 36.5f;
                standardLevelMaxValue = 42.5f;
            }
        }
        if (value < lowLeverMaxValue) {
            levelMsg = "偏低";
            level = 2;
            info = "您缺少足够的肌肉，需要加强运动，增加肌肉。";
        } else if (value <= lowLeverMaxValue && value <= standardLevelMaxValue) {
            level = 3;
            info = "您的肌肉比较发达，继续保持";
        } else {
            level = 4;
            info = "您的肌肉比较发达，继续保持";
        }
        return setQingNiuBean(info, levelMsg, offset, "kg", level);

    }

    // 骨量
    public QingNiuBean getBoneMass(float weight, float value, int sex) {
        typeName = "骨量";
        typeImg = R.drawable.ic_report_bone;
        if (sex == 1) {
            if (weight <= 60) {
                lowLeverMaxValue = 2.3f;
                standardLevelMaxValue = 2.7f;

            } else if (60 < value && value < 75) {
                lowLeverMaxValue = 2.7f;
                standardLevelMaxValue = 3.1f;

            } else {
                lowLeverMaxValue = 3.0f;
                standardLevelMaxValue = 3.4f;
            }
        } else {
            if (weight <= 45) {
                lowLeverMaxValue = 1.6f;
                standardLevelMaxValue = 2.0f;
            } else if (45 < value && value < 60) {
                lowLeverMaxValue = 2.0f;
                standardLevelMaxValue = 2.4f;
            } else {
                lowLeverMaxValue = 2.3f;
                standardLevelMaxValue = 2.7f;
            }
        }
        if (value < lowLeverMaxValue) {
            levelMsg = "偏低";
            level = 2;
            info = "您的骨量水平偏低。长期低钙饮食、缺乏运动、过度减肥等都可能引起骨量偏低，多吃含钙高的食物，多晒太阳，多运动及时补钙。";
        } else if (lowLeverMaxValue <= value && standardLevelMaxValue <= value) {
            level = 3;
            info = "您的骨量水平标准。骨量在短期内不会出现明显的变化，您只要保持健康的饮食和适当的锻炼，就可以维持稳定健康的骨量水平。";
        } else {
            levelMsg = "偏高";
            level = 4;
            info = "您的骨量水平偏高。说明骨骼中包含的钙等无机盐的含量非常充分，但要注意防范肾结石、低血压的风险，尽量避免高钙摄入。";

        }

        return setQingNiuBean(info, levelMsg, offset, "%", level);
    }

    // 蛋白质
    public QingNiuBean getProtein(float value, int sex) {
        typeName = "蛋白质";
        typeImg = R.drawable.ic_report_protein;
        level_4 = "充足";
        level_4_color = R.color.levelFull;
        if (sex == 1) {
            lowLeverMaxValue = 16;
            standardLevelMaxValue = 18;


        } else {
            lowLeverMaxValue = 14;
            standardLevelMaxValue = 16;
        }
        if (value < lowLeverMaxValue) {
            levelMsg = "偏低";
            level = 2;
            offset = value - lowLeverMaxValue;
            info = "蛋白质不足会引起基础代谢减少，也会引起肌肉的数量减少。坚持长期运动，适当提高肌肉比列，辅助于蛋白质的补充，可以提升蛋白质比列。蛋白质：生命的物质基础，是构成细胞的基本有机物。";
        } else if (lowLeverMaxValue <= value && value <= standardLevelMaxValue) {
            level = 3;
            info = "您的蛋白质处于标准水平。蛋白质：生命的物质基础，是构成细胞的基本有机物。";
        } else {
            offset = value - standardLevelMaxValue;
            level = 4;
            info = "蛋白质比例充足。蛋白质：生命的物质基础，是构成细胞的基本有机物。";
        }
        return setQingNiuBean(info, levelMsg, offset, "%", level);
    }

    // 内脏脂肪等级
    public QingNiuBean getVisceralFat(float value) {
        typeName = "内脏脂肪等级";
        typeImg = R.drawable.ic_report_visfat;
        standardLevelMaxValue = 9;
        highLevelMaxValue = 14;
        if (value <= standardLevelMaxValue) {
            level = 3;
            info = "内脏脂肪指数标准，暂时没有太大风险。";
            if (level == standardLevelMaxValue) {
                info += "您虽然处于标准范围，但内脏脂肪已经开始堆积，请积极运动，改变久坐不动、饮食不均衡等不良习惯。";
            }
        } else if (standardLevelMaxValue < value && value <= highLevelMaxValue) {
            offset = value - standardLevelMaxValue;
            levelMsg = "偏高";
            level = 4;
            info = "内脏脂肪指数偏高，持续保持均衡饮食和适当的运动，以标准程度为目标，进行适当运动和限制卡路里。";
        } else {
            offset = value - standardLevelMaxValue;
            levelMsg = "严重偏高";
            level = 5;
            info = "内脏脂肪指数危险，罹患心脏病、高血压、高血脂和||型糖尿病风险大，您迫切需要控制体重、积极运动和限制饮食。";
        }
        return setQingNiuBean(info, levelMsg, offset, "", level);
    }

    // 体年龄
    public QingNiuBean getBodyAge(int value, int age) {
        typeName = "体年龄";
        typeImg = R.drawable.ic_report_bodyage;
        int sw = age * 2 / 3;
        info = "理想的体内年龄=实际年龄 * 2 / 3，您还有年轻空间，加油";
        offset = value - sw;
        if (offset > 0) {
            levelMsg = "不达标";
        }
        return setQingNiuBean(info, levelMsg, offset, "岁", level);
    }

    // 基础代谢
    public QingNiuBean getBMR(float weight, int age, int sex, int value) {
        typeName = "基础代谢";
        typeImg = R.drawable.ic_report_bmr;
        float sa;
        if (sex == 1) {
            if (18 <= age && age <= 29) {
                sa = 24;
            } else if (30 <= age && age <= 49) {
                sa = 22.3f;
            } else if (50 <= age && age <= 69) {
                sa = 21.5f;
            } else {
                sa = 21.5f;
            }
        } else {
            if (18 <= age && age <= 29) {
                sa = 23.6f;
            } else if (30 <= age && age <= 49) {
                sa = 21.7f;
            } else if (50 <= age && age <= 69) {
                sa = 20.7f;
            } else {
                sa = 20.7f;
            }
        }
        // 标准
        float sw = sa * weight;
        if (value >= sw) {
            info = "您的标准基础代谢率为" + value + "kcal，处于达标状态。保持基础代谢率最有效的方式是每天都进行适量的运动。";
        } else {
            info = "您的标准基础代谢率为" + value + "kcal，处于未达标状态。持续轻量运动能够提高身体的基础代谢率，而节食基础代谢会大幅下降。";
            levelMsg = "不达标";

        }
        offset = value - sw;

        return setQingNiuBean(info, levelMsg, offset, "kcal", level);

    }

    private QingNiuBean setQingNiuBean(String info, String title, double value, String unit, int level) {
        QingNiuBean bean = new QingNiuBean();
        String msg;
        if (value > 0) {
            msg = "比标准值多了" + value + unit;
        } else {
            msg = "比标准值少了" + Math.abs(value) + unit;
        }
        bean.setInfo(info);
        bean.setLevelMsg(title);
        bean.setOffsetInfo(msg);
        bean.setLevel(level);
        bean.setUnit(unit);
        bean.setLowerLeverMaxValue(lowerLeverMaxValue);
        bean.setLowLeverMaxValue(lowLeverMaxValue);
        bean.setStandardLevelMaxValue(standardLevelMaxValue);
        bean.setHighLevelMaxValue(highLevelMaxValue);
        bean.setLevel_1(level_1);
        bean.setLevel_2(level_2);
        bean.setLevel_3(level_3);
        bean.setLevel_4(level_4);
        bean.setLevel_5(level_5);
        bean.setLevel_1_color(level_1_color);
        bean.setLevel_2_color(level_2_color);
        bean.setLevel_3_color(level_3_color);
        bean.setLevel_4_color(level_4_color);
        bean.setLevel_5_color(level_5_color);
        bean.setTypeImg(typeImg);
        bean.setTypeName(typeName);
        return bean;
    }
}
