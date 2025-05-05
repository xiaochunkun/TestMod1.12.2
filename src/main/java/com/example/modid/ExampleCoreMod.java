package com.example.modid;

import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.Collections;
import java.util.List;

/**
 * @author 小坤
 * @since 2025/5/6 00:44
 */
public class ExampleCoreMod implements ILateMixinLoader {
    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixins.modid.json");
    }
}
