package com.jiangchangxiong.starter.mp.meta;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.jiangchangxiong.constants.EntityConstant;
import com.jiangchangxiong.starter.mp.core.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * @author Jiang
 * @since  2023-02-20
 */
public class CustomMetaObjectHandler implements MetaObjectHandler {

    @Autowired
    private UidGenerator uidGenerator;

    @Override
    public void insertFill(MetaObject metaObject) {
        fillCreated(metaObject);
        fillUpdated(metaObject);
        fillId(metaObject);
    }

    /**
     * 所有的继承了Entity、SuperEntity的实体，在update时，
     * updatedBy: 自动赋予 当前线程上的登录人id
     * updateTime: 自动赋予 服务器的当前时间
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        fillUpdated(metaObject);
    }


    private void fillId(MetaObject metaObject) {
        if (uidGenerator == null) {
            // 这里使用SpringUtils的方式"异步"获取对象，防止启动时，报循环注入的错
            uidGenerator = SpringUtil.getBean(UidGenerator.class);
        }
        Long id = uidGenerator.getUid();

        //1. 继承了BaseEntity 若 ID 中有值，就不设置
        if (metaObject.getOriginalObject() instanceof BaseEntity) {
            Object oldId = ((BaseEntity) metaObject.getOriginalObject()).getId();
            if (oldId != null) {
                return;
            }
            this.setFieldValByName(EntityConstant.ID, id, metaObject);
            return;
        }

        // 2. 没有继承BaseEntity， 但主键的字段名为：  id
        if (metaObject.hasGetter(EntityConstant.ID)) {
            Object oldId = metaObject.getValue(EntityConstant.ID);
            if (oldId != null) {
                return;
            }

            this.setFieldValByName(EntityConstant.ID, id, metaObject);
        }
    }

    private void fillCreated(MetaObject metaObject) {
        // 设置创建时间和创建人
        if (metaObject.getOriginalObject() instanceof BaseEntity) {
            created(metaObject);
            return;
        }

        if (metaObject.hasGetter(EntityConstant.CREATE_BY)) {
            Object oldVal = metaObject.getValue(EntityConstant.CREATE_BY);
            if (oldVal == null) {
                if (StpUtil.getLoginIdDefaultNull() != null) {
                    // 有些未登录就会注入字段，防止这种情况，用户存在时才设置
                    this.setFieldValByName(EntityConstant.CREATE_BY, StpUtil.getLoginIdDefaultNull(), metaObject);
                }
            }
        }
        if (metaObject.hasGetter(EntityConstant.CREATE_TIME)) {
            Object oldVal = metaObject.getValue(EntityConstant.CREATE_TIME);
            if (oldVal == null) {
                this.setFieldValByName(EntityConstant.CREATE_TIME, LocalDateTime.now(), metaObject);
            }
        }

    }

    private void created(MetaObject metaObject) {
        BaseEntity entity = (BaseEntity) metaObject.getOriginalObject();
        if (entity.getCreateTime() == null) {
            this.setFieldValByName(EntityConstant.CREATE_TIME, LocalDateTime.now(), metaObject);
        }
        if (metaObject.hasGetter(EntityConstant.CREATE_BY)) {
            if (StpUtil.getLoginIdDefaultNull() != null) {
                // 有些未登录就会注入字段，防止这种情况，用户存在时才设置
                Object userIdVal = StpUtil.getLoginIdDefaultNull();
                this.setFieldValByName(EntityConstant.CREATE_BY, userIdVal, metaObject);
            }
        }
    }


    private void fillUpdated(MetaObject metaObject) {
        // 修改人 修改时间
        if (metaObject.getOriginalObject() instanceof BaseEntity) {
            update(metaObject);
            return;
        }

        if (metaObject.hasGetter(EntityConstant.UPDATE_BY)) {
            if (StpUtil.getLoginIdDefaultNull() != null) {
                // 有些未登录就会注入字段，防止这种情况，用户存在时才设置
                this.setFieldValByName(EntityConstant.UPDATE_BY, StpUtil.getLoginIdDefaultNull(), metaObject);
            }
        }
        if (metaObject.hasGetter(EntityConstant.UPDATE_TIME)) {
            this.setFieldValByName(EntityConstant.UPDATE_TIME, LocalDateTime.now(), metaObject);
        }
    }

    private void update(MetaObject metaObject) {
        if (StpUtil.getLoginIdDefaultNull() != null) {
            this.setFieldValByName(EntityConstant.UPDATE_BY, StpUtil.getLoginIdDefaultNull(), metaObject);
        }
        this.setFieldValByName(EntityConstant.UPDATE_TIME, LocalDateTime.now(), metaObject);
    }

}
