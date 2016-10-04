package entitiescleaner.cleaner;

import java.util.Arrays;

import cn.nukkit.Server;
import cn.nukkit.entity.item.EntityItem;
import cn.nukkit.entity.item.EntityXPOrb;

public class EntityCleaner implements Cleaner {

	@Override
	public void clean() {
		Server.getInstance().getLevels().forEach((name, level) -> Arrays.asList(level.getEntities()).forEach(entity -> {
			if (entity instanceof EntityXPOrb || entity instanceof EntityItem) entity.close();
		}));
	}
}
